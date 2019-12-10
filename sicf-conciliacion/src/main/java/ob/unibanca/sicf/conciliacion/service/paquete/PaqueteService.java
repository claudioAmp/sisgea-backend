package ob.unibanca.sicf.conciliacion.service.paquete;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.conciliacion.mapper.IPaqueteMapper;
import ob.unibanca.sicf.conciliacion.model.Paquete;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaqueteService extends MantenibleService<Paquete> implements IPaqueteService {
	
	private static final String PAQUETE_NO_ENCONTRADO = "El Paquete %s no existe";
	private final IPaqueteMapper paqueteMapper;
	
	public PaqueteService(@Qualifier("IPaqueteMapper") IMantenibleMapper<Paquete> mantenibleMapper) {
		super(mantenibleMapper);
		this.paqueteMapper = (IPaqueteMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Paquete> buscarTodosPaquetes() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Paquete registrarPaquete(Paquete paquete) {
		this.registrar(paquete);
		return this.buscarPaquete(paquete.getIdPaquete());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Paquete actualizarPaquete(Integer idPaquete,Paquete paquete) {
		paquete.setIdPaquete(idPaquete);
		this.actualizar(paquete);
		return this.buscarPaquete(paquete.getIdPaquete());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPaquete(Integer idPaquete) {
		Paquete paquete = Paquete.builder().idPaquete(idPaquete).build();
		this.eliminar(paquete);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Paquete buscarPaquete(Integer idPaquete) {
		return this.paqueteMapper.buscarPaquete(idPaquete).orElseThrow(
				() -> new RecursoNoEncontradoException(PAQUETE_NO_ENCONTRADO, idPaquete));
	}
}
