package edu.taller.sisgea.generadorconsultas.service.filtro;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Filtro;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaFiltro;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface IFiltroService extends IMantenibleService<Filtro> {

    public List<Filtro> buscarTodosFiltro();
    
    List<Filtro> buscarPorCriteriosFiltro(CriterioBusquedaFiltro criterio);
	
	Filtro registrarFiltro(Filtro filtro);
	
	Filtro actualizarFiltro(int idFiltroCampo, Filtro filtro);
	
	void eliminarFiltro(int idFiltroCampo);

}