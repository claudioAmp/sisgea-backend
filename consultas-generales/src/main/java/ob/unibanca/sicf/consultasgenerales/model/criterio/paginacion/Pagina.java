package ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion;

import java.util.List;

import lombok.Data;

@Data
public class Pagina {
	//private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<? extends ItemPagina> data;
}
