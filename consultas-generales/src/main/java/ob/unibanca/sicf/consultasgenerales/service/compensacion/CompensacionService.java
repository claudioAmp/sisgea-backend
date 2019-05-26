package ob.unibanca.sicf.consultasgenerales.service.compensacion;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.consultasgenerales.mapper.ICompensacionMapper;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.Compensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.CompensacionDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;

@Service
public class CompensacionService implements  ICompensacionService{
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final ICompensacionMapper compensacionMapper;
	
	public CompensacionService(ICompensacionMapper compensacionMapper) {
		this.compensacionMapper = compensacionMapper;
	}

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
	
}
