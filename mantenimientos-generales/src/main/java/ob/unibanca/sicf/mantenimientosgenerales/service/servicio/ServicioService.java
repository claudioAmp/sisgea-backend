package ob.unibanca.sicf.mantenimientosgenerales.service.servicio;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IServicioMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Servicio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioService extends MantenibleService<Servicio> implements IServicioService {

	private static final String Servicio_NO_ENCONTRADO = "El servicio %s-%s no fue encontrado";
	private final IServicioMapper servicioMapper;

	public ServicioService(@Qualifier("IServicioMapper") IMantenibleMapper<Servicio> mantenibleMapper) {
		super(mantenibleMapper);
		this.servicioMapper = (IServicioMapper) mantenibleMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Servicio registrarServicio(Servicio servicio) {
		this.registrar(servicio);
		return this.buscarServicio(servicio.getIdMembresia(), servicio.getIdServicio());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Servicio actualizarServicio(String idMembresia, String idServicio, Servicio servicio) {
		servicio.setIdMembresia(idMembresia);
		servicio.setIdServicio(idServicio);
		this.actualizar(servicio);
		return this.buscarServicio(servicio.getIdMembresia(), servicio.getIdServicio());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarServicio(String idMembresia, String idServicio) {
		Servicio servicio = Servicio.builder().idMembresia(idMembresia).idServicio(idServicio).build();
		this.eliminar(servicio);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Servicio> buscarTodosServicios() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Servicio buscarServicio(String idMembresia, String idServicio) {
		return this.servicioMapper.buscarUno(idMembresia, idServicio)
				.orElseThrow(() -> new RecursoNoEncontradoException(Servicio_NO_ENCONTRADO, idMembresia, idServicio));
	}

}
