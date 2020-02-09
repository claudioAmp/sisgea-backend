package edu.taller.sisgea.generadorconsultas.service.tablaforanea;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.generadorconsultas.model.TablasForaneas;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTablasForaneas;


public interface ITablasForaneasService extends IMantenibleService<TablasForaneas> {
	
	List<TablasForaneas> buscarTodosTablasForaneas();
	
	TablasForaneas buscarTablaForaneaPorId(Integer idRelacionTablaFk);
	
	List<TablasForaneas> buscarPorCriteriosTablasForaneas(CriterioBusquedaTablasForaneas criterio);
	
    TablasForaneas registrarTablasForaneas(TablasForaneas tablaForanea);
	
	TablasForaneas actualizarTablasForaneas(int idRelacionTablaFk, TablasForaneas tablaForanea);
	
	void eliminarTablasForaneas(int idRelacionTablaFk);
}

