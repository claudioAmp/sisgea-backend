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
	public void registrarPortafolio(Portafolio portafolio) {
		this.registrar(portafolio);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void actualizarPortafolio(Portafolio portafolio) {
		this.actualizar(portafolio);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPortafolio(Portafolio portafolio) {
		this.eliminar(portafolio);
	}
}
