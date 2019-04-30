package ob.unibanca.sicf.generadorconsultas.service.tabla;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Tabla;


public interface ITablaService extends IMantenibleService<Tabla> {
	List<Tabla> buscarTodosTablas();
	

}
