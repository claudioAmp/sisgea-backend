package ob.unibanca.sicf.reportes.service.tabla;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.reportes.model.Tabla;

public interface ITablaService extends IMantenibleService<Tabla> {
	List<Tabla> buscarTodosTablas();
}
