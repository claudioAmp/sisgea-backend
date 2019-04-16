package ob.unibanca.sicf.consultasgenerales.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ob.commons.util.StringsUtils;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Columna;

public class PaginacionUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(PaginacionUtils.class);
	
	private PaginacionUtils() {
		throw new UnsupportedOperationException();
	}

	public static <S> List<Columna> getFiltros(List<String> toStrings, Class<S> clazz) {
		System.out.println(toStrings);
		System.out.println(toStrings.size());
		List<Columna> columns = new ArrayList<>();
		List<Map<String, Object>> propsList = new ArrayList<>();
		toStrings.forEach(toString -> propsList.add(PaginacionUtils.fromToStringToMap(toString)));
		propsList.forEach(props -> {
			Columna column = BeansUtils.setFieldsFromMap(Columna.class, props); 
			String name = null;
			try {
				System.out.println(column);
				name = column.getName();
				clazz.getDeclaredField(name);				
				column.setName(StringsUtils.convertirCamelCaseToUnderscore(name));
				System.out.println(column);
				columns.add(column);
			} catch (NoSuchFieldException | SecurityException e) {
				logger.error("Error controlado al obtener la propiedas {} de {}", name, clazz.getName());
			}			
		});
		return columns;
	}
	
	public static String getOrderExpression(List<Columna> columns) {
		String orderExpression = "";
		if(columns.isEmpty()) {
			orderExpression = "id_mov_txn_swdmplog desc";
		} else {
			List<String> parts = new ArrayList<>();
			columns.forEach(column -> parts.add(column.getName().concat(" ").concat(column.getOrder())));
			orderExpression = StringUtils.join(parts);
		}
		return orderExpression;
	}
	
	public static Map<String, Object> fromToStringToMap(String fullToString) {
		Map<String, Object> props = new HashMap<>();
		String toString = fullToString.substring(fullToString.indexOf('(') + 1, fullToString.indexOf(')'));
		String[] pairs = toString.split(Pattern.quote("|"));
		for(int i = 0; i< pairs.length; i ++) {
			String[] values = pairs[i].trim().split("=");
			props.put(values[0], values[1]);
		}		
		return props;
	}
}
