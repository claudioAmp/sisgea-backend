package ob.unibanca.sicf.facturacion.service.detraccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.facturacion.model.Detraccion;

@Service
public class DetraccionService extends MantenibleService<Detraccion> implements IDetraccionService {

	public DetraccionService(@Qualifier("IDetraccionMapper") IMantenibleMapper<Detraccion> mantenibleMapper) {
		super(mantenibleMapper);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Detraccion> buscarTodosDetraccion() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Detraccion registrarDetraccion(Detraccion detraccion) {
		this.registrar(detraccion);
		return detraccion;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Detraccion actualizarDetraccion(int idDetraccion, Detraccion detraccion) {
		detraccion.setIdDetraccion(idDetraccion);
		this.actualizar(detraccion);
		return detraccion;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarDetraccion(int idDetraccion) {
		Detraccion detraccion = Detraccion.builder().idDetraccion(idDetraccion).build();
		this.eliminar(detraccion);
	}

}
