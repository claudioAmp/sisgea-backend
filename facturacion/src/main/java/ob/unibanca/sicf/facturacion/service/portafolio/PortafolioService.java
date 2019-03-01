package ob.unibanca.sicf.facturacion.service.portafolio;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.facturacion.model.Portafolio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PortafolioService extends MantenibleService<Portafolio> implements IPortafolioService {
	
	public PortafolioService(@Qualifier("IPortafolioMapper") IMantenibleMapper<Portafolio> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Portafolio> buscarTodosPortafolios() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Portafolio registrarPortafolio(Portafolio portafolio) {
		this.registrar(portafolio);
		return portafolio;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Portafolio actualizarPortafolio(int idPortafolio, Portafolio portafolio) {
		portafolio.setIdPortafolio(idPortafolio); this.actualizar(portafolio);
		return portafolio;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPortafolio(int idPortafolio) {
		Portafolio portafolio = Portafolio.builder().idPortafolio(idPortafolio).build();
		this.eliminar(portafolio);
	}
}
