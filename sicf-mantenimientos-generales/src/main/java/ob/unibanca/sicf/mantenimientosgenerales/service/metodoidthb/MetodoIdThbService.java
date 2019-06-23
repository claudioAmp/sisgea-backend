package ob.unibanca.sicf.mantenimientosgenerales.service.metodoidthb;

import java.util.List;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IMetodoIdThbMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.MetodoIdThb;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MetodoIdThbService extends MantenibleService<MetodoIdThb> implements IMetodoIdThbService{
    
	private static final String METODO_ID_THB_NO_ENCONTRADO =
			"No existe la asociación entre el metodo id thb %s y la membresía %s";
	private final IMetodoIdThbMapper metodoIdThbMapper;
	
	public MetodoIdThbService(@Qualifier("IMetodoIdThbMapper") IMantenibleMapper<MetodoIdThb> mantenibleMapper) {
		super(mantenibleMapper);
		this.metodoIdThbMapper = (IMetodoIdThbMapper) mantenibleMapper;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MetodoIdThb registrarMetodoIdThb(String idMembresia, MetodoIdThb metodoIdThb) {
		metodoIdThb.setIdMembresia(idMembresia);
		this.registrar(metodoIdThb);
		return this.buscarMetodoIdThb(metodoIdThb.getIdMembresia(), metodoIdThb.getIdMetodoIdThb());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MetodoIdThb actualizarMetodoIdThb(String idMembresia, String idMetodoIdThb, MetodoIdThb metodoIdThb) {
		metodoIdThb.setIdMembresia(idMembresia);
		metodoIdThb.setIdMetodoIdThb(idMetodoIdThb);
		this.actualizar(metodoIdThb);
		return this.buscarMetodoIdThb(metodoIdThb.getIdMembresia(), metodoIdThb.getIdMetodoIdThb());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarMetodoIdThb(String idMembresia, String idMetodoIdThb) {
		MetodoIdThb metodoIdThb = MetodoIdThb.builder().idMembresia(idMembresia).idMetodoIdThb(idMetodoIdThb).build();
		this.eliminar(metodoIdThb);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<MetodoIdThb> buscarTodosMetodoIdThb() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public MetodoIdThb buscarMetodoIdThb(String idMembresia, String idMetodoIdThb) {
		return this.metodoIdThbMapper.buscarMetodoIdThb(idMembresia, idMetodoIdThb).orElseThrow(
				() -> new RecursoNoEncontradoException(METODO_ID_THB_NO_ENCONTRADO, idMetodoIdThb, idMembresia));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<MetodoIdThb> buscarMetodoIdThbPorMembresia(String idMembresia) {
		return this.metodoIdThbMapper.buscarMetodoIdThbPorMembresia(idMembresia);
	}
}
