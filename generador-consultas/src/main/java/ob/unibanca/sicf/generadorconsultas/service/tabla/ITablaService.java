package ob.unibanca.sicf.generadorconsultas.service.tabla;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Tabla;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTabla;


public interface ITablaService extends IMantenibleService<Tabla> {

	List<Tabla> buscarTodosTabla();
	
	List<Tabla> buscarPorCriteriosTabla(CriterioBusquedaTabla criterio);
	
	Tabla registrarTabla(Tabla Tabla);
	
	Tabla actualizarTabla(int idTabla, Tabla Tabla);
	
	void eliminarTabla(int idTabla);
	

}
