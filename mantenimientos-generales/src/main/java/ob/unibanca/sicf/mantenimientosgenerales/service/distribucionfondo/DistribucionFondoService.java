package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionfondo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IDistribucionFondoMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionFondo;

@Service
public class DistribucionFondoService extends MantenibleService<DistribucionFondo> implements IDistribucionFondoService{
	
	private static final String DISTRIBUCION_FONDO_NO_ENCONTRADO = "La regla de Distribución Fondo %s no existe";
	private final IDistribucionFondoMapper distribucionFondoMapper;
	
	public DistribucionFondoService(@Qualifier("IDistribucionFondoMapper") IMantenibleMapper<DistribucionFondo> mantenibleMapper) {
		super(mantenibleMapper);
		this.distribucionFondoMapper = (IDistribucionFondoMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<DistribucionFondo> buscarTodosDistFondo(){
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DistribucionFondo buscarDistribucionFondo(int idDistribucionFondo) {
		return this.distribucionFondoMapper.buscarDistribucionFondo(idDistribucionFondo).orElseThrow(
				() -> new RecursoNoEncontradoException(DISTRIBUCION_FONDO_NO_ENCONTRADO, idDistribucionFondo));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DistribucionFondo registrarDistribucionComision(DistribucionFondo distribucionFondo) {
		this.registrar(distribucionFondo);
		return this.buscarDistribucionFondo(distribucionFondo.getIdDistribucionFondo());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DistribucionFondo actualizarDistribucionFondo(int idDistribucionFondo, DistribucionFondo distribucionFondo) {
		distribucionFondo.setIdDistribucionFondo(idDistribucionFondo);
		this.actualizar(distribucionFondo);
		return this.buscarDistribucionFondo(distribucionFondo.getIdDistribucionFondo());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarDistribucionFondo(int idDistribucionFondo) {
		DistribucionFondo distribucionFondo = DistribucionFondo.builder().idDistribucionFondo(idDistribucionFondo).build();
		this.eliminar(distribucionFondo);
	}
	
}
