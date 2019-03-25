package ob.unibanca.sicf.facturacion.service.codigofacturacion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.CodigoFacturacion;

import java.util.List;

public interface ICodigoFacturacionService extends IMantenibleService<CodigoFacturacion> {
	
	List<CodigoFacturacion> buscarTodosCodigosFacturaciones();
	
	CodigoFacturacion registrarCodigoFacturacion(CodigoFacturacion codigoFacturacion);
	
	CodigoFacturacion actualizarCodigoFacturacion(int idCodigoFacturacion, CodigoFacturacion codigoFacturacion);
	
	void eliminarCodigoFacturacion(int idCodigoFacturacion);
}
