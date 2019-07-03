package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc10;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaTC10Mapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0Det;


@Service
public class IncomingVisaTC10Service implements IIncomingVisaTC10Service {
	
	private static final String TRCX_NO_ENCONTRADO = "No existe un TCR%s con identificación de secuencia indicada";
	private final IIncomingVisaTC10Mapper incomingVisaTC10Mapper;
	
	public IncomingVisaTC10Service(IIncomingVisaTC10Mapper incomingVisaTC10Mapper) {
		this.incomingVisaTC10Mapper = incomingVisaTC10Mapper;
	}
	
	public Page<IncomingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(
			CriterioBusquedaIncomingVisaTC10 criterioBusqueda, int pageNo, int pageSize){
		
		
		PageHelper.startPage(pageNo, pageSize);
		
		return incomingVisaTC10Mapper.buscarPorCriteriosTCR0(criterioBusqueda);
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC10TCR0Det buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio){
		
		return this.incomingVisaTC10Mapper.buscarPorIdSecuenciaTCR0(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"0"));
	}
	
	public Page<IncomingVisaTC10TCR0> buscaPorCriteriosTCR0PorPaginaAggrid(
			CriterioBusquedaIncomingVisaTC10 criterioBusqueda,
			Pagina<CriterioBusquedaIncomingVisaTC10, IncomingVisaTC10TCR0>criterioPaginacion){
		
		PageHelper.startPage(criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return incomingVisaTC10Mapper.buscarPorCriteriosTCR0Aggrid(criterioBusqueda);
		
	}
	
	
}
