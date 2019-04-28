package ob.unibanca.sicf.mantenimientosgenerales.service.roltransaccion;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.RolTransaccion;

public interface IRolTransaccionService extends IMantenibleService<RolTransaccion> {

	List<RolTransaccion> buscarTodosRolesTransacciones();
}
