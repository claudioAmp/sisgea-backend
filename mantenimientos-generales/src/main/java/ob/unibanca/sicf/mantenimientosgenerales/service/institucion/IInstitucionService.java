package ob.unibanca.sicf.mantenimientosgenerales.service.institucion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;

import java.util.List;

public interface IInstitucionService extends IMantenibleService<Institucion> {
	
	List<Institucion> buscarTodosInstituciones();
	
	void registrarInstitucion(Institucion institucion);
	
	void actualizarInstitucion(int idInstitucion, Institucion institucion);
	
	void eliminarInstitucion(int idInstitucion);
}
