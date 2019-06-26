package ob.unibanca.sicf.generadorconsultas.model.criterio.paginacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageParameter {

	private int pageNum;
	private int pageSize;

}
