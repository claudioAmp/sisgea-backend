package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR5;




@Service
public class IncomingVisaService implements IIncomingVisaService{
	
	
	private static final String TRCX_NO_ENCONTRADO = "No existe un TCR%s con identificación de secuencia indicada";
	private final IIncomingVisaMapper incomingVisaMapper;
	
	public IncomingVisaService(IIncomingVisaMapper incomingVisaMapper) {
		this.incomingVisaMapper = incomingVisaMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTCR0> buscaPorCriteriosTCR0PorPagina(CriterioBusquedaIncomingVisaTCR0 criterioBusqueda,
			int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		
		return incomingVisaMapper.buscarPorCriteriosTCR0(criterioBusqueda);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR0(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"0"));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR1(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"1"));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR3 buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR3(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"3"));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR4 buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR4(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"4"));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR5 buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR5(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"5"));
	}


	
	
}
