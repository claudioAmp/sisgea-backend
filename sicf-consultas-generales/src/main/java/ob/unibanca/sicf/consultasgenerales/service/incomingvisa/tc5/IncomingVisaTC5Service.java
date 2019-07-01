package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaTC5Mapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;

@Service
public class IncomingVisaTC5Service implements IIncomingVisaTC5Service{
		
	private static final String TRCX_NO_ENCONTRADO = "No existe un TCR%s con identificación de secuencia indicada";
	private final IIncomingVisaTC5Mapper incomingVisaTC5Mapper;
	
	public IncomingVisaTC5Service(IIncomingVisaTC5Mapper incomingVisaTC5Mapper) {
		this.incomingVisaTC5Mapper = incomingVisaTC5Mapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTC5> buscaPorCriteriosTC5PorPagina(CriterioBusquedaIncomingVisaTC5 criterioBusqueda, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return incomingVisaTC5Mapper.buscarPorCriteriosTC5(criterioBusqueda);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaIncomingVisa criterio){
		//return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR0(criterio).orElseThrow(() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"0"));
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR0(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaIncomingVisa criterio){
		//return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR1(criterio).orElseThrow(() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"1"));
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR1(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR3 buscarPorIdSecuenciaTC5TCR3(CriterioBusquedaIncomingVisa criterio){
		//return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR3(criterio).orElseThrow(() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"3"));
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR3(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR4 buscarPorIdSecuenciaTC5TCR4(CriterioBusquedaIncomingVisa criterio){
		//return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR4(criterio).orElseThrow(() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"4"));
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR4(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaIncomingVisa criterio){
		//return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR5(criterio).orElseThrow(() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"5"));
		return this.incomingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR5(criterio);
	}


	
	
}
