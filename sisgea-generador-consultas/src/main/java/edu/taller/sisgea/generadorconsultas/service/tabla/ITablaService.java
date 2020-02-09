package edu.taller.sisgea.generadorconsultas.service.tabla;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Tabla;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTabla;
import ob.commons.mantenimiento.service.IMantenibleService;


public interface ITablaService extends IMantenibleService<Tabla> {

	List<Tabla> buscarTodosTabla();
	
	List<Tabla> buscarPermitidosTabla();
	
	List<Tabla> buscarPorCriteriosTabla(CriterioBusquedaTabla criterio);
	
	Tabla registrarTabla(Tabla Tabla);
	
	Tabla actualizarTabla(int idTabla, Tabla Tabla);
	
	void eliminarTabla(int idTabla);
	

}
