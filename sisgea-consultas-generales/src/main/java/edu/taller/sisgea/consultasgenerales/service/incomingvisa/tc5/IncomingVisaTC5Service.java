package edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc5;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.IIncomingVisaTC5Mapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.*;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import edu.taller.sisgea.consultasgenerales.mapper.IIncomingVisaTC5Mapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR3;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomingVisaTC5Service implements IIncomingVisaTC5Service {
	
	private final IIncomingVisaTC5Mapper incomingVisaTC5Mapper;
	
	public IncomingVisaTC5Service(IIncomingVisaTC5Mapper incomingVisaTC5Mapper) {
		this.incomingVisaTC5Mapper = incomingVisaTC5Mapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTC5> buscaPorCriteriosTC5PorPagina(CriterioBusquedaIncomingVisaTC5 criterioBusqueda,
                                                               int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return incomingVisaTC5Mapper.buscarPorCriteriosTC5(criterioBusqueda);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR0(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR1(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR3 buscarPorIdSecuenciaTC5TCR3(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR3(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR4 buscarPorIdSecuenciaTC5TCR4(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR4(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR5(criterio);
	}
}
