package edu.taller.sisgea.mantenimientosgenerales.service.institucion;

import edu.taller.sisgea.mantenimientosgenerales.model.Institucion;
import edu.taller.sisgea.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IInstitucionService extends IMantenibleService<Institucion> {
	
	List<Institucion> buscarTodosInstituciones();

	Institucion buscarInstitucion(int idInstitucion);
	
	List<Institucion> buscarPorCriterios(CriterioBusquedaInstitucion criterio);
	
	Institucion registrarInstitucion(Institucion institucion);
	
	Institucion actualizarInstitucion(int idInstitucion, Institucion institucion);
	
	void eliminarInstitucion(int idInstitucion);
}
