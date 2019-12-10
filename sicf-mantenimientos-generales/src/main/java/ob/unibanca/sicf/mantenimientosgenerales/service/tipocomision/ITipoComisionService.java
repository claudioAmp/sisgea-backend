package ob.unibanca.sicf.mantenimientosgenerales.service.tipocomision;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.TipoComision;

public interface ITipoComisionService extends IMantenibleService<TipoComision> {
	
	List<TipoComision> buscarTodosTiposComision();
	
	TipoComision  buscarPorIdTipoComision(Integer idTipoComision);
}
