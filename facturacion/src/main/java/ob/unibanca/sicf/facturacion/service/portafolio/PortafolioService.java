package ob.unibanca.sicf.facturacion.service.portafolio;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.facturacion.mapper.IPortafolioMapper;
import ob.unibanca.sicf.facturacion.model.Portafolio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PortafolioService extends MantenibleService<Portafolio> implements IPortafolioService {
	
	private static final String PORTAFOLIO_NO_ENCONTRADO = "El portafolio %s no fue encontrado";
	private final IPortafolioMapper portafolioMapper;

	public PortafolioService(@Qualifier("IPortafolioMapper") IMantenibleMapper<Portafolio> mantenibleMapper) {
		super(mantenibleMapper);
		this.portafolioMapper = (IPortafolioMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Portafolio> buscarTodosPortafolios() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Portafolio buscarPortafolio(int idPortafolio) {
		return this.portafolioMapper.buscarUno(idPortafolio).orElseThrow(
				() -> new RecursoNoEncontradoException(PORTAFOLIO_NO_ENCONTRADO, idPortafolio));
	}
		
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Portafolio registrarPortafolio(Portafolio portafolio) {
		this.registrar(portafolio);
		return this.buscarPortafolio(portafolio.getIdPortafolio());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Portafolio actualizarPortafolio(int idPortafolio, Portafolio portafolio) {
		portafolio.setIdPortafolio(idPortafolio); 
		this.actualizar(portafolio);
		return this.buscarPortafolio(portafolio.getIdPortafolio());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPortafolio(int idPortafolio) {
		Portafolio portafolio = Portafolio.builder().idPortafolio(idPortafolio).build();
		this.eliminar(portafolio);
	}
}
