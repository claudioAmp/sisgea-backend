package ob.unibanca.sicf.consultasgenerales.model.criterio;

import java.util.List;
import lombok.Data;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.ItemPagina;

@Data
public class CriterioPaginacion<T,S> {
	
	private Integer start;
	private Integer length;
	private String orderExpression;
	
	private T criterioBusqueda;
	private S filtrosDatatable;
	private List<? extends ItemPagina> resultados;
}
