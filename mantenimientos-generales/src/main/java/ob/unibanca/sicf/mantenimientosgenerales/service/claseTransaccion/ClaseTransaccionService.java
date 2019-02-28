package ob.unibanca.sicf.mantenimientosgenerales.service.claseTransaccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ClaseTransaccion;

@Service
public class ClaseTransaccionService extends MantenibleService<ClaseTransaccion> implements IClaseTransaccionService {

	public ClaseTransaccionService(@Qualifier("IClaseTransaccionMapper") IMantenibleMapper<ClaseTransaccion> mantenibleMapper) {
		super(mantenibleMapper);		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ClaseTransaccion> buscarTodosClaseTransacciones() {
		return super.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ClaseTransaccion registrarClaseTransaccion(ClaseTransaccion claseTransaccion) {
		super.registrar(claseTransaccion); return claseTransaccion;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ClaseTransaccion actualizarClaseTransaccion(int idClaseTransaccion, ClaseTransaccion claseTransaccion) {
		claseTransaccion.setIdClaseTransaccion(idClaseTransaccion); super.actualizar(claseTransaccion); return claseTransaccion;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarClaseTransaccion(int idClaseTransaccion) {
		ClaseTransaccion claseTransaccion = ClaseTransaccion.builder().idClaseTransaccion(idClaseTransaccion).build(); super.eliminar(claseTransaccion);
	}
	
}
