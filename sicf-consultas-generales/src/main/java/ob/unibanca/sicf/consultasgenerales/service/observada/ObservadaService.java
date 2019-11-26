package ob.unibanca.sicf.consultasgenerales.service.observada;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.IObservadaMapper;
import ob.unibanca.sicf.consultasgenerales.model.observada.Observada;
import ob.unibanca.sicf.consultasgenerales.model.observada.ObservadaDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.observada.CriterioBusquedaObservada;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObservadaService implements IObservadaService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final IObservadaMapper observadaMapper;
	
	public ObservadaService(IObservadaMapper observadaMapper) {
		this.observadaMapper = observadaMapper;
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Observada> buscarPorCriterios(CriterioBusquedaObservada criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return observadaMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ObservadaDetalle buscarDetalle(CriterioBusquedaObservada criterio) {
		return this.observadaMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getSecuenciaArchivo()));
	}
	
}
