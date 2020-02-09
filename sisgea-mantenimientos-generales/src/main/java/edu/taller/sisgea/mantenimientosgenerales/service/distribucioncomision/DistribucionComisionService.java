package edu.taller.sisgea.mantenimientosgenerales.service.distribucioncomision;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.mapper.IDistribucionComisionMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.DistribucionComision;

@Service
public class DistribucionComisionService extends MantenibleService<DistribucionComision> implements IDistribucionComisionService{
	
	private static final String DISTRIBUCION_COMISION_NO_ENCONTRADO = "La regla de Distribución Comision %s no existe";
	private final IDistribucionComisionMapper distribucionComisionMapper;
	
	public DistribucionComisionService(@Qualifier("IDistribucionComisionMapper") IMantenibleMapper<DistribucionComision> mantenibleMapper) {
		super(mantenibleMapper);
		this.distribucionComisionMapper = (IDistribucionComisionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<DistribucionComision> buscarTodosDistComision(){
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DistribucionComision buscarDistribucionComision(int idDistribucionComision) {
		return this.distribucionComisionMapper.buscarDistribucionComision(idDistribucionComision).orElseThrow(
				() -> new RecursoNoEncontradoException(DISTRIBUCION_COMISION_NO_ENCONTRADO, idDistribucionComision));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DistribucionComision registrarDistribucionComision(DistribucionComision distribucionComision) {
		this.registrar(distribucionComision);
		return this.buscarDistribucionComision(distribucionComision.getIdDistribucionComision());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DistribucionComision actualizarDistribucionComision(int idDistribucionComision, DistribucionComision distribucionComision) {
		distribucionComision.setIdDistribucionComision(idDistribucionComision);
		this.actualizar(distribucionComision);
		return this.buscarDistribucionComision(distribucionComision.getIdDistribucionComision());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarDistribucionComision(int idDistribucionComision) {
		DistribucionComision distribucionComision = DistribucionComision.builder().idDistribucionComision(idDistribucionComision).build();
		this.eliminar(distribucionComision);
	}

}
