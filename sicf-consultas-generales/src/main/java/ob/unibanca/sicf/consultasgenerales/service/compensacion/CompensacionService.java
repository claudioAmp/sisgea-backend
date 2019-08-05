package ob.unibanca.sicf.consultasgenerales.service.compensacion;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.ICompensacionMapper;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.ComisCompensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.Compensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.CompensacionDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompensacionService implements  ICompensacionService{
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final ICompensacionMapper compensacionMapper;
	
	public CompensacionService(ICompensacionMapper compensacionMapper) {
		this.compensacionMapper = compensacionMapper;
	}

	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Compensacion> buscarPorCriterios(CriterioBusquedaCompensacion criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		
		return compensacionMapper.buscarPorCriterios(criterioPaginacion);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CompensacionDetalle buscarPorSecuencia(CriterioBusquedaCompensacion criterio) {
		return this.compensacionMapper.buscarPorSecuencia(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getIdSecuencia()));
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ComisCompensacion> buscarComisionesPorSecuencia(CriterioBusquedaCompensacion criterio) {
		
		return this.compensacionMapper.buscarComisionesPorSecuencia(criterio);
	}
	
}
