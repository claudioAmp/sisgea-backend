package ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion;

import java.util.List;

import lombok.Data;

@Data
public class CriterioPaginacion2 {
	private int pageNum;
	private int pageSize;
	private List<String> filtros;
}
