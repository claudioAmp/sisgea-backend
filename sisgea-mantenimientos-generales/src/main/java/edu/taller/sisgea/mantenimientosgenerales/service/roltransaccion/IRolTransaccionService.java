package edu.taller.sisgea.mantenimientosgenerales.service.roltransaccion;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.RolTransaccion;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface IRolTransaccionService extends IMantenibleService<RolTransaccion> {

	List<RolTransaccion> buscarTodosRolesTransacciones();
}
