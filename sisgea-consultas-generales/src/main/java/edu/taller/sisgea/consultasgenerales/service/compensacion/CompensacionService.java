package edu.taller.sisgea.consultasgenerales.service.compensacion;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.ICompensacionMapper;
import edu.taller.sisgea.consultasgenerales.model.compensacion.ComisCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.Compensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.CompensacionDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;
import ob.commons.error.exception.RecursoNoEncontradoException;
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

	//@TruncablePAN
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
