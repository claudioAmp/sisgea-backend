package ob.unibanca.sicf.mantenimientosgenerales.service.membresia;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Membresia;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MembresiaService extends MantenibleService<Membresia> implements IMembresiaService {
	
	public MembresiaService(@Qualifier("IMembresiaMapper") IMantenibleMapper<Membresia> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Membresia> buscarTodosMembresias() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Membresia registrarMembresia(Membresia membresia) {
		this.registrar(membresia); return membresia;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Membresia actualizarMembresia(String idMembresia, Membresia membresia) {
		membresia.setIdMembresia(idMembresia); this.actualizar(membresia); return membresia;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarMembresia(String idMembresia) {
		Membresia membresia = Membresia.builder().idMembresia(idMembresia).build(); this.eliminar(membresia);
	}
}
