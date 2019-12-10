package ob.unibanca.sicf.conciliacion.service.campoactualizar;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.conciliacion.mapper.ICampoActualizarMapper;
import ob.unibanca.sicf.conciliacion.model.CampoActualizar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampoActualizarService extends MantenibleService<CampoActualizar> implements ICampoActualizarService {
	
	private static final String CAMPO_ACTUALIZAR_NO_ENCONTRADO = "No existe la asociación entre el campo actualizar %s y la tabla de conciliación %s";
	private final ICampoActualizarMapper campoActualizarMapper;
	
	public CampoActualizarService(@Qualifier("ICampoActualizarMapper") IMantenibleMapper<CampoActualizar> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoActualizarMapper = (ICampoActualizarMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoActualizar> buscarTodosCamposActualizar() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CampoActualizar buscarCampoActualizar(Integer idCampoActualizar,Integer idConcTabla) {
		return this.campoActualizarMapper.buscarCampoActualizar(idCampoActualizar, idConcTabla).orElseThrow(
				() -> new RecursoNoEncontradoException(CAMPO_ACTUALIZAR_NO_ENCONTRADO, idCampoActualizar, idConcTabla));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoActualizar> buscarCampoActualizarPorConciliacionTablas(Integer idConcTabla) {
		return this.campoActualizarMapper.buscarCampoActualizarPorConciliacionTablas(idConcTabla);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoActualizar registrarCampoActualizar(Integer idConcTabla, CampoActualizar campoActualizar) {
		this.registrar(campoActualizar);
		return this.buscarCampoActualizar(campoActualizar.getIdCampoActualizar(), campoActualizar.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoActualizar actualizarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla, CampoActualizar campoActualizar) {
		campoActualizar.setIdCampoActualizar(idCampoActualizar);
		campoActualizar.setIdConcTabla(idConcTabla);
		this.actualizar(campoActualizar);
		return this.buscarCampoActualizar(campoActualizar.getIdCampoActualizar(), campoActualizar.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla) {
		CampoActualizar campoActualizar = CampoActualizar.builder().idCampoActualizar(idCampoActualizar).idConcTabla(idConcTabla).build();
		this.eliminar(campoActualizar);
	}
	
}
