package ob.unibanca.sicf.facturacion.service.portafolio;

import ob.unibanca.sicf.facturacion.model.Portafolio;
import ob.unibanca.sicf.facturacion.service.base.IMantenibleService;

public interface IPortafolioService extends IMantenibleService<Portafolio> {
	
	void registrarFacturacion(Portafolio portafolio);
	
	void actualizarFacturacion(Portafolio portafolio);
	
	void eliminarFacturacion(int idPortafolio);
}
