package ob.unibanca.sicf.generadorconsultas.model.criterio.paginacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageParameter {

	private int pageNumber;
	private int pageSize;

}
