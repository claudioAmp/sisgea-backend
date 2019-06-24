package ob.unibanca.sicf.consultasgenerales.util.pagination.builder;

import static com.google.common.collect.Streams.zip;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import com.google.common.collect.Sets;
import ob.unibanca.sicf.consultasgenerales.util.pagination.filter.ColumnFilter;
import ob.unibanca.sicf.consultasgenerales.util.pagination.filter.NumberColumnFilter;
import ob.unibanca.sicf.consultasgenerales.util.pagination.filter.SetColumnFilter;
import ob.unibanca.sicf.consultasgenerales.util.pagination.request.ColumnVO;
import ob.unibanca.sicf.consultasgenerales.util.pagination.request.EnterpriseGetRowsRequest;
import ob.unibanca.sicf.consultasgenerales.util.pagination.request.SortModel;

public class OracleSqlQueryBuilder {
	private List<String> groupKeys;
	private List<String> rowGroups;
	private List<String> rowGroupsToInclude;
	private boolean isGrouping;
	private List<ColumnVO> valueColumns;
	private List<ColumnVO> pivotColumns;
	private Map<String, ColumnFilter> filterModel;
	private List<SortModel> sortModel;
	private int startRow, endRow;
	private List<ColumnVO> rowGroupCols;
	private Map<String, List<String>> pivotValues;
	private boolean isPivotMode;

	public void createSql(EnterpriseGetRowsRequest request /* , String tableName, Map<String, List<String>> pivotValues */) {
		this.valueColumns = request.getValueCols();
		this.pivotColumns = request.getPivotCols();
		this.groupKeys = request.getGroupKeys();
		this.rowGroupCols = request.getRowGroupCols();
		// this.pivotValues = pivotValues;
		this.isPivotMode = request.isPivotMode();
		this.rowGroups = getRowGroups();
		this.rowGroupsToInclude = getRowGroupsToInclude();
		this.isGrouping = rowGroups.size() > groupKeys.size();
		this.filterModel = request.getFilterModel();
		this.sortModel = request.getSortModel();
		// this.startRow = request.getStartRow();
		// this.endRow = request.getEndRow();

		// return selectSql() + fromSql(tableName) + whereSql() + groupBySql() +
		// orderBySql() + limitSql();
	}

	public String selectSql() {
		List<String> selectCols;
		if (isPivotMode && !pivotColumns.isEmpty()) {
			selectCols = concat(rowGroupsToInclude.stream(), extractPivotStatements()).collect(toList());
		} else {
			Stream<String> valueCols = valueColumns.stream()
					.map(valueCol -> valueCol.getAggFunc() + '(' + valueCol.getField() + ") as " + valueCol.getField());

			selectCols = concat(rowGroupsToInclude.stream(), valueCols).collect(toList());
		}

		return isGrouping ? "SELECT " + join(", ", selectCols) : "SELECT *";
	}
	/*
	 * private String fromSql(String tableName) { return format(" FROM %s",
	 * tableName); }
	 */

	public String whereSql() {
		String whereFilters = concat(getGroupColumns(), getFilters()).collect(joining(" AND "));

		return whereFilters.isEmpty() ? "" : format("AND %s", whereFilters);
	}

	public String groupBySql() {
		return isGrouping ? " GROUP BY " + join(", ", rowGroupsToInclude) : "";
	}

	public String orderBySql() {
		Function<SortModel, String> orderByMapper = model -> model.getColId() + " " + model.getSort();

		boolean isDoingGrouping = rowGroups.size() > groupKeys.size();
		int num = isDoingGrouping ? groupKeys.size() + 1 : MAX_VALUE;

		List<String> orderByCols = sortModel.stream()
				.filter(model -> !isDoingGrouping || rowGroups.contains(model.getColId())).map(orderByMapper).limit(num)
				.collect(toList());

		return orderByCols.isEmpty() ? "" : " ORDER BY " + join(",", orderByCols);
	}
	/*
	 * private String limitSql() { return " OFFSET " + startRow +
	 * " ROWS FETCH NEXT " + (endRow - startRow + 1) + " ROWS ONLY"; }
	 */

	public Stream<String> getFilters() {
		Function<Map.Entry<String, ColumnFilter>, String> applyFilters = entry -> {
			String columnName = entry.getKey();
			ColumnFilter filter = entry.getValue();

			if (filter instanceof SetColumnFilter) {
				return setFilter().apply(columnName, (SetColumnFilter) filter);
			}

			if (filter instanceof NumberColumnFilter) {
				return numberFilter().apply(columnName, (NumberColumnFilter) filter);
			}

			return "";
		};

		return filterModel.entrySet().stream().map(applyFilters);
	}

	public BiFunction<String, SetColumnFilter, String> setFilter() {
		return (String columnName, SetColumnFilter filter) -> columnName
				+ (filter.getValues().isEmpty() ? " IN ('') " : " IN " + asString(filter.getValues()));
	}

	public BiFunction<String, NumberColumnFilter, String> numberFilter() {
		return (String columnName, NumberColumnFilter filter) -> {
			Integer filterValue = filter.getFilter();
			String filerType = filter.getType();
			String operator = operatorMap.get(filerType);

			return columnName
					+ (filerType.equals("inRange") ? " BETWEEN " + filterValue + " AND " + filter.getFilterTo()
							: " " + operator + " " + filterValue);
		};
	}

	private Stream<String> extractPivotStatements() {

		// create pairs of pivot col and pivot value i.e. (DEALTYPE,Financial),
		// (BIDTYPE,Sell)...
		List<Set<Pair<String, String>>> pivotPairs = pivotValues.entrySet().stream().map(e -> e.getValue().stream()
				.map(pivotValue -> Pair.of(e.getKey(), pivotValue)).collect(toCollection(LinkedHashSet::new)))
				.collect(toList());

		// create a cartesian product of decode statements for all pivot and value
		// columns combinations
		// i.e. sum(DECODE(DEALTYPE, 'Financial', DECODE(BIDTYPE, 'Sell',
		// CURRENTVALUE)))
		return Sets.cartesianProduct(pivotPairs).stream().flatMap(pairs -> {
			String pivotColStr = pairs.stream().map(Pair::getRight).collect(joining("_"));

			String decodeStr = pairs.stream().map(pair -> "DECODE(" + pair.getLeft() + ", '" + pair.getRight() + "'")
					.collect(joining(", "));

			String closingBrackets = IntStream.range(0, pairs.size() + 1).mapToObj(i -> ")").collect(joining(""));

			return valueColumns.stream().map(valueCol -> valueCol.getAggFunc() + "(" + decodeStr + ", "
					+ valueCol.getField() + closingBrackets + " \"" + pivotColStr + "_" + valueCol.getField() + "\"");
		});
	}

	public List<String> getRowGroupsToInclude() {
		return rowGroups.stream().limit(groupKeys.size() + 1).collect(toList());
	}

	public Stream<String> getGroupColumns() {
		return zip(groupKeys.stream(), rowGroups.stream(), (key, group) -> group + " = '" + key + "'");
	}

	public List<String> getRowGroups() {
		return rowGroupCols.stream().map(ColumnVO::getField).collect(toList());
	}

	public String asString(List<String> l) {
		return "(" + l.stream().map(s -> "\'" + s + "\'").collect(joining(", ")) + ")";
	}

	public Map<String, String> operatorMap = new HashMap<String, String>() {
		{
			put("equals", "=");
			put("notEqual", "<>");
			put("lessThan", "<");
			put("lessThanOrEqual", "<=");
			put("greaterThan", ">");
			put("greaterThanOrEqual", ">=");
		}
	};

}
