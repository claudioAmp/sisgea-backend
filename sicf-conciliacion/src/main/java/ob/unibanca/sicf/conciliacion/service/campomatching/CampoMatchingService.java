package ob.unibanca.sicf.conciliacion.service.campomatching;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.conciliacion.mapper.ICampoMatchingMapper;
import ob.unibanca.sicf.conciliacion.model.CampoMatching;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampoMatchingService extends MantenibleService<CampoMatching> implements ICampoMatchingService {
	
	private static final String CAMPO_MATCHING_NO_ENCONTRADO = "No existe la asociación entre el campo matching %s y la tabla de conciliación %s";
	private final ICampoMatchingMapper campoMatchingMapper;
	
	public CampoMatchingService(@Qualifier("ICampoMatchingMapper") IMantenibleMapper<CampoMatching> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoMatchingMapper = (ICampoMatchingMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoMatching> buscarTodosCamposMatching() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CampoMatching buscarCampoMatching(Integer idCampoMatching,Integer idConcTabla) {
		return this.campoMatchingMapper.buscarCampoMatching(idCampoMatching, idConcTabla).orElseThrow(
				() -> new RecursoNoEncontradoException(CAMPO_MATCHING_NO_ENCONTRADO, idCampoMatching, idConcTabla));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoMatching> buscarCampoMatchingPorConciliacionTablas(Integer idConcTabla) {
		return this.campoMatchingMapper.buscarCampoMatchingPorConciliacionTablas(idConcTabla);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoMatching registrarCampoMatching(Integer idConcTabla, CampoMatching campoMatching) {
		this.registrar(campoMatching);
		return this.buscarCampoMatching(campoMatching.getIdCampoMatching(), campoMatching.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoMatching actualizarCampoMatching(Integer idCampoMatching, Integer idConcTabla, CampoMatching campoMatching) {
		campoMatching.setIdCampoMatching(idCampoMatching);
		campoMatching.setIdConcTabla(idConcTabla);
		this.actualizar(campoMatching);
		return this.buscarCampoMatching(campoMatching.getIdCampoMatching(), campoMatching.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCampoMatching(Integer idCampoMatching, Integer idConcTabla) {
		CampoMatching campoMatching = CampoMatching.builder().idCampoMatching(idCampoMatching).idConcTabla(idConcTabla).build();
		this.eliminar(campoMatching);
	}
	
}
