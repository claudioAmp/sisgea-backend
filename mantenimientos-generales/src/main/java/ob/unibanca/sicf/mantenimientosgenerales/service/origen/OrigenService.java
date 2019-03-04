package ob.unibanca.sicf.mantenimientosgenerales.service.origen;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IOrigenMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Origen;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrigenService extends MantenibleService<Origen> implements IOrigenService {
	
	private static final String ORIGEN_NO_ENCONTRADO = "El origen %s no fue encontrado";
	private final IOrigenMapper origenMapper;

	public OrigenService(@Qualifier("IOrigenMapper") IMantenibleMapper<Origen> mantenibleMapper) {
		super(mantenibleMapper);
		this.origenMapper = (IOrigenMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Origen> buscarTodosOrigenes() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Origen buscarOrigen(int idOrigen) {
		return this.origenMapper.buscarUno(idOrigen).orElseThrow(
				() -> new RecursoNoEncontradoException(ORIGEN_NO_ENCONTRADO, idOrigen));
	}
		
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Origen registrarOrigen(Origen origen) {
		this.registrar(origen);
		return this.buscarOrigen(origen.getIdOrigen());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Origen actualizarOrigen(int idOrigen, Origen origen) {
		origen.setIdOrigen(idOrigen); 
		this.actualizar(origen);
		return this.buscarOrigen(origen.getIdOrigen());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarOrigen(int idOrigen) {
		Origen origen = Origen.builder().idOrigen(idOrigen).build();
		this.eliminar(origen);
	}
}
