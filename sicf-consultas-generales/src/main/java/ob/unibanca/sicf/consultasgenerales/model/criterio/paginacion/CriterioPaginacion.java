package ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion;

import lombok.Data;

@Data
public class CriterioPaginacion<T> {
	
	private T criterioBusqueda;
	
	private int pageNo;
	private int pageSize;

}
