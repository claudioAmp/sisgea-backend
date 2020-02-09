package edu.taller.sisgea.mantenimientosgenerales.service.servicio;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IServicioMapper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Servicio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioService extends MantenibleService<Servicio> implements IServicioService {
	
	private static final String SERVICIO_NO_ENCONTRADO =
			"No existe la asociación entre el servicio %s y la membresía %s";
	private final IServicioMapper servicioMapper;
	
	public ServicioService(@Qualifier("IServicioMapper") IMantenibleMapper<Servicio> mantenibleMapper) {
		super(mantenibleMapper);
		this.servicioMapper = (IServicioMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Servicio registrarServicio(String idMembresia, Servicio servicio) {
		servicio.setIdMembresia(idMembresia);
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
		return this.servicioMapper.buscarServicio(idMembresia, idServicio).orElseThrow(
				() -> new RecursoNoEncontradoException(SERVICIO_NO_ENCONTRADO, idServicio, idMembresia));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Servicio> buscarServiciosPorMembresia(String idMembresia) {
		return this.servicioMapper.buscarServiciosPorMembresia(idMembresia);
	}
}
