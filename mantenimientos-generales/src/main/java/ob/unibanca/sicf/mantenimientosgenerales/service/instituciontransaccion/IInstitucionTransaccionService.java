package ob.unibanca.sicf.mantenimientosgenerales.service.instituciontransaccion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.InstitucionTransaccion;

import java.util.List;

public interface IInstitucionTransaccionService extends IMantenibleService<InstitucionTransaccion> {
	
	List<InstitucionTransaccion> buscarTodosInstitucionesTransacciones();
	
	InstitucionTransaccion buscarInstitucionTransaccion(int idInstitucion, int idClaseTransaccion,
	                                                    int idCodigoTransaccion);
	
	InstitucionTransaccion registrarInstitucionTransaccion(int idInstitucion,
	                                                       InstitucionTransaccion institucionTransaccion);
	
	void eliminarInstitucionTransaccion(int idInstitucion, int idClaseTransaccion, int idCodigoTransaccion);
}
