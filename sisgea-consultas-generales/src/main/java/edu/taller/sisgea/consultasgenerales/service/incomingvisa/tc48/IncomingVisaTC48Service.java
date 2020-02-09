package edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc48;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import edu.taller.sisgea.consultasgenerales.mapper.IIncomingVisaTC48Mapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomingVisaTC48Service implements IIncomingVisaTC48Service {
	
	private final IIncomingVisaTC48Mapper incomingVisaTC48Mapper;
	
	public IncomingVisaTC48Service(IIncomingVisaTC48Mapper incomingVisaTC48Mapper) {
		this.incomingVisaTC48Mapper = incomingVisaTC48Mapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTC48> buscaPorCriteriosPaginado(CriterioBusquedaIncomingVisaTC48 criterioBusqueda,
	                                                        int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return incomingVisaTC48Mapper.buscarPorCriterios(criterioBusqueda);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC48Mapper.buscarPorIdSecuenciaTCR0(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC48Mapper.buscarPorIdSecuenciaTCR1(criterio);
		
	}
}
