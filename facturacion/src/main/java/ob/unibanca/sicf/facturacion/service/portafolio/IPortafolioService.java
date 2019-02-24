package ob.unibanca.sicf.facturacion.service.portafolio;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.Portafolio;

import java.util.List;

public interface IPortafolioService extends IMantenibleService<Portafolio> {
	
	List<Portafolio> buscarTodosPortafolios();
	
	void registrarPortafolio(Portafolio portafolio);
	
	void actualizarPortafolio(Portafolio portafolio);
	
	void eliminarPortafolio(Portafolio portafolio);
}
