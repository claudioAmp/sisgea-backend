package ob.unibanca.sicf.facturacion.service.portafolio;

import ob.unibanca.sicf.facturacion.mapper.base.IMantenibleMapper;
import ob.unibanca.sicf.facturacion.model.Portafolio;
import ob.unibanca.sicf.facturacion.service.base.MantenibleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortafolioService extends MantenibleService<Portafolio> implements IPortafolioService {
	
	public PortafolioService(@Qualifier("IPortafolioMapper") IMantenibleMapper<Portafolio> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registrarFacturacion(Portafolio portafolio) {
		this.registrar(portafolio);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void actualizarFacturacion(Portafolio portafolio) {
		this.actualizar(portafolio);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarFacturacion(int idPortafolio) {
		Portafolio portafolio = Portafolio.builder().idPortafolio(idPortafolio).build(); this.eliminar(portafolio);
	}
}
