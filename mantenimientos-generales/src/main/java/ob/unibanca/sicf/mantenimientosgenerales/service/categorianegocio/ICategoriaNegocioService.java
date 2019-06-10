package ob.unibanca.sicf.mantenimientosgenerales.service.categorianegocio;

import java.util.List;
import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CategoriaNegocio;




public interface ICategoriaNegocioService extends IMantenibleService<CategoriaNegocio> {
	List<CategoriaNegocio> buscarTodosCategoriasNegocios();
}
