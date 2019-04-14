package ob.unibanca.sicf.consultasgenerales.model.utilitario;

import java.util.List;

import ob.commons.util.StringsUtils;

import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.ItemPagina;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;


public class PaginacionUtils {
	
	public static <T> Pagina generarPagina(List<? extends ItemPagina> data, 
			CriterioPaginacion<T> criterioPaginacion){
		Integer totalFilas = data.isEmpty() ? 0 : data.get(0).getTotalFilas();
    	Pagina pagina = new Pagina();
    	//pagina.setDraw(criterioPaginacion.getDraw());
    	/*pagina.setData(data);
    	pagina.setRecordsFiltered(totalFilas);
    	pagina.setRecordsTotal(totalFilas);*/
    	return pagina;
	}
	public static <T> String obtenerExpresionOrdenamiento(CriterioPaginacion<T> criterioPaginacion){
		String expresionOrdenamiento = "";
		/*List<CriterioOrdenamiento> criteriosOrdenamiento = criterioPaginacion.getOrder();
		List<Columna> columnas = criterioPaginacion.getColumns();
		List<String> expresiones = new ArrayList<>();
		if(criteriosOrdenamiento != null){
			criteriosOrdenamiento.stream().forEach(co -> {
				Integer columna = co.getColumn();
				String data =  columnas.get(columna).getData();
				expresiones.add(data + " " + co.getDir());			
			});
		}		*/
		expresionOrdenamiento = StringsUtils.unir("", ",");		
		return expresionOrdenamiento;
	}
}
