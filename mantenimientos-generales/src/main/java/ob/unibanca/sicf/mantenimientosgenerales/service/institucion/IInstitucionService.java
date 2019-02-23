package ob.unibanca.sicf.mantenimientosgenerales.service.institucion;

import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.base.IMantenibleService;

public interface IInstitucionService extends IMantenibleService<Institucion> {
	
	void registrarInstitucion(Institucion institucion);
	
	void actualizarInstitucion(Institucion institucion);
	
	void eliminarInstitucion(int idInstitucion);
}
