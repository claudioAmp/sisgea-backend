package ob.unibanca.sicf.conciliacion.service.campoinsertarobservada;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.conciliacion.mapper.ICampoInsertarObservadaMapper;
import ob.unibanca.sicf.conciliacion.model.CampoInsertarObservada;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampoInsertarObservadaService extends MantenibleService<CampoInsertarObservada> implements ICampoInsertarObservadaService {
	
	private static final String CAMPO_INSERTAR_OBSERVADA_NO_ENCONTRADO = "No existe la asociación entre el campo insertar observada %s y la tabla de conciliación %s";
	private final ICampoInsertarObservadaMapper campoInsertarObservadaMapper;
	
	public CampoInsertarObservadaService(@Qualifier("ICampoInsertarObservadaMapper") IMantenibleMapper<CampoInsertarObservada> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoInsertarObservadaMapper = (ICampoInsertarObservadaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoInsertarObservada> buscarTodosCampoInsertarObservadas() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CampoInsertarObservada buscarCampoInsertarObservada(Integer idCmpInsObservada,Integer idConcTabla) {
		return this.campoInsertarObservadaMapper.buscarCampoInsertarObservada(idCmpInsObservada, idConcTabla).orElseThrow(
				() -> new RecursoNoEncontradoException(CAMPO_INSERTAR_OBSERVADA_NO_ENCONTRADO, idCmpInsObservada, idConcTabla));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoInsertarObservada> buscarCampoInsertarObservadaPorConciliacionTablas(Integer idConcTabla) {
		return this.campoInsertarObservadaMapper.buscarCampoInsertarObservadaPorConciliacionTablas(idConcTabla);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoInsertarObservada registrarCampoInsertarObservada(Integer idConcTabla, CampoInsertarObservada campoInsertarObservada) {
		this.registrar(campoInsertarObservada);
		return this.buscarCampoInsertarObservada(campoInsertarObservada.getIdCmpInsObservada(), campoInsertarObservada.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoInsertarObservada actualizarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla, CampoInsertarObservada campoInsertarObservada) {
		campoInsertarObservada.setIdCmpInsObservada(idCmpInsObservada);
		campoInsertarObservada.setIdConcTabla(idConcTabla);
		this.actualizar(campoInsertarObservada);
		return this.buscarCampoInsertarObservada(campoInsertarObservada.getIdCmpInsObservada(), campoInsertarObservada.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla) {
		CampoInsertarObservada campoInsertarObservada = CampoInsertarObservada.builder().idCmpInsObservada(idCmpInsObservada).idConcTabla(idConcTabla).build();
		this.eliminar(campoInsertarObservada);
	}
	
}
