package edu.taller.sisgea.consultasgenerales.service.dcindiners;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.IDcinChargeMapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinChargeDetalle;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import edu.taller.sisgea.consultasgenerales.mapper.IDcinChargeMapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinChargeDetalle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DcinChargeService implements IDcinChargeService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final IDcinChargeMapper dcinChargeMapper;
	
	public DcinChargeService(IDcinChargeMapper dcinChargeMapper) {
		this.dcinChargeMapper = dcinChargeMapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<DcinCharge> buscarPorCriterios(CriterioBusquedaDcinCharge criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return dcinChargeMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public DcinChargeDetalle buscarDetalle(CriterioBusquedaDcinCharge criterio) {
		return this.dcinChargeMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getIdDcin()));
	}
	
}
