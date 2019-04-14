package ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion;

import java.util.List;
import lombok.Data;

@Data
public class CriterioPaginacion<T> {
	//private Integer draw;
	private Integer start;
	private Integer length;
	//private String orderExpression;
	//private List<CriterioOrdenamiento> order;
	//private List<Columna> columns;
	
	private T criterioBusqueda;
	//private S filtrosDatatable;
	private List<? extends ItemPagina> resultados;
}
