package ob.unibanca.sicf.facturacion.service.portafolio;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.Portafolio;

import java.util.List;

public interface IPortafolioService extends IMantenibleService<Portafolio> {
	
	List<Portafolio> buscarTodosPortafolios();
	
	Portafolio buscarPortafolio(int idPortafolio);
	
	Portafolio registrarPortafolio(Portafolio portafolio);
	
	Portafolio actualizarPortafolio(int idPortafolio, Portafolio portafolio);
	
	void eliminarPortafolio(int idPortafolio);
}
