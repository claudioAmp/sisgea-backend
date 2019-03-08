package ob.unibanca.sicf.mantenimientosgenerales.service.instituciontransaccion;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.InstitucionTransaccion;

public interface IInstitucionTransaccionService extends IMantenibleService<InstitucionTransaccion> {
	
	List<InstitucionTransaccion> buscarTodosInstitucionesTransacciones();
	
	InstitucionTransaccion buscarInstitucionTransaccion(int idInstitucion, int idClaseTransaccion, int idCodigoTransaccion);
	
	InstitucionTransaccion registrarInstitucionTransaccion(InstitucionTransaccion institucionTransaccion);
	
	void eliminarInstitucionTransaccion(int idInstitucion, int idClaseTransaccion, int idCodigoTransaccion);
}
