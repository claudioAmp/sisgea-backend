package ob.unibanca.sicf.generadorconsultas.service.filtro;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaFiltro;

public interface IFiltroService extends IMantenibleService<Filtro> {

    public List<Filtro> buscarTodosFiltro();
    
    List<Filtro> buscarPorCriteriosFiltro(CriterioBusquedaFiltro criterio);
	
	Filtro registrarFiltro(Filtro filtro);
	
	Filtro actualizarFiltro(int idFiltroCampo, Filtro filtro);
	
	void eliminarFiltro(int idFiltroCampo);

}