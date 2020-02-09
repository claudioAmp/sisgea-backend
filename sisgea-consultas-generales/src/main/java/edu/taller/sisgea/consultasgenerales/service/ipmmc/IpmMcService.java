package edu.taller.sisgea.consultasgenerales.service.ipmmc;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.IIpmMcMapper;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMcDetalle;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import edu.taller.sisgea.consultasgenerales.mapper.IIpmMcMapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.ipmmc.CriterioBusquedaIpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMcDetalle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IpmMcService implements IIpmMcService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final IIpmMcMapper ipmMcMapper;
	
	public IpmMcService(IIpmMcMapper ipmMcMapper) {
		this.ipmMcMapper = ipmMcMapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IpmMc> buscarPorCriterios(CriterioBusquedaIpmMc criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return ipmMcMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IpmMcDetalle buscarDetalle(CriterioBusquedaIpmMc criterio) {
		return this.ipmMcMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getTramsKey()));
	}
}
