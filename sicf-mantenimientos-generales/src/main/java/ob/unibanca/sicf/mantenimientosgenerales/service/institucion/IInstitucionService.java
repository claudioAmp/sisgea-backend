package ob.unibanca.sicf.mantenimientosgenerales.service.institucion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;

import java.util.List;

public interface IInstitucionService extends IMantenibleService<Institucion> {
	
	List<Institucion> buscarTodosInstituciones();

	Institucion buscarInstitucion(int idInstitucion);
	
	List<Institucion> buscarPorCriterios(CriterioBusquedaInstitucion criterio);
	
	Institucion registrarInstitucion(Institucion institucion);
	
	Institucion actualizarInstitucion(int idInstitucion, Institucion institucion);
	
	void eliminarInstitucion(int idInstitucion);
}