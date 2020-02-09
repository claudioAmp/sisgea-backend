package edu.taller.sisgea.mantenimientosgenerales.service.origen;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Origen;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrigenService extends MantenibleService<Origen> implements IOrigenService {
	
	public OrigenService(@Qualifier("IOrigenMapper") IMantenibleMapper<Origen> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Origen> buscarTodosOrigenes() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Origen registrarOrigen(Origen origen) {
		this.registrar(origen);
		return origen;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Origen actualizarOrigen(int idOrigen, Origen origen) {
		origen.setIdOrigen(idOrigen);
		this.actualizar(origen);
		return origen;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarOrigen(int idOrigen) {
		Origen origen = Origen.builder().idOrigen(idOrigen).build();
		this.eliminar(origen);
	}
}
