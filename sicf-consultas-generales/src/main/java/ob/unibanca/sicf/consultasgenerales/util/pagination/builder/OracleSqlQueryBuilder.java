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
	private boolean isGrouping;
	private Map<String, ColumnFilter> filterModel;
	private List<SortModel> sortModel;
	private int startRow, endRow;
	private Map<String, List<String>> pivotValues;
	private boolean isPivotMode;


	
	public String orderBySql() {
		Function<SortModel, String> orderByMapper = model -> model.getColId() + " " + model.getSort();

		boolean isDoingGrouping = rowGroups.size() > groupKeys.size();
		int num = isDoingGrouping ? groupKeys.size() + 1 : MAX_VALUE;

		List<String> orderByCols = sortModel.stream()
				.filter(model -> !isDoingGrouping || rowGroups.contains(model.getColId())).map(orderByMapper).limit(num)
				.collect(toList());

		return orderByCols.isEmpty() ? "" : " ORDER BY " + join(",", orderByCols);
	}

	public List<String> getRowGroupsToInclude() {
		return rowGroups.stream().limit(groupKeys.size() + 1).collect(toList());
	}

	public Stream<String> getGroupColumns() {
		return zip(groupKeys.stream(), rowGroups.stream(), (key, group) -> group + " = '" + key + "'");
	}

	public List<String> getRowGroups() {
		//return rowGroupCols.stream().map(ColumnVO::getField).collect(toList());
		//Que se inicialice vacia
		return null;
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
	
	
	
	
	public void createSql(EnterpriseGetRowsRequest request ) {
		/*Solo para que funcione*/
		this.groupKeys = request.getGroupKeys();
		this.isGrouping = rowGroups.size() > groupKeys.size();
		/*Inicializa */
		this.filterModel = request.getFilterModel();
		this.sortModel = request.getSortModel();
	}
	
	public String selectSql() {
		return "SELECT *";
	}
	
	public String whereSql() {
		System.out.println(getFilters());
		System.out.println(getFilters().collect(joining(" AND ")));
		String whereFilters =  getFilters().collect(joining(" AND "));
		
		return whereFilters.isEmpty() ? "" : format("AND %s", whereFilters);
	}
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
}
