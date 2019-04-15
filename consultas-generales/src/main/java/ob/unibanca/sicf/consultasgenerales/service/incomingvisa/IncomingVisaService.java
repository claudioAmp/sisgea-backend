package ob.unibanca.sicf.consultasgenerales.service.incomingvisa;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR5;




@Service
public class IncomingVisaService implements IIncomingVisaService{
	
	
	private static final String TRCX_NO_ENCONTRADO =
			"No existe un TCR%d con identificación de secuencia %d";
	private final IIncomingVisaMapper incomingVisaMapper;
	
	public IncomingVisaService(IIncomingVisaMapper incomingVisaMapper) {
		this.incomingVisaMapper = incomingVisaMapper;
	}
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTCR0> buscaPorCriteriosTCR0(CriterioBusquedaIncomingVisaTCR0 criterioBusqueda) {
		CriterioPaginacion<CriterioBusquedaIncomingVisaTCR0> criterioPaginacion= new CriterioPaginacion<>();
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		criterioPaginacion.setPageNo(1);
		criterioPaginacion.setPageSize(15);
		
		PageHelper.startPage(criterioPaginacion.getPageNo(), criterioPaginacion.getPageSize()); 

       return incomingVisaMapper.buscarPorCriteriosTCR0(criterioBusqueda); 
    }
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR1 buscarPorIdSecuenciaTCR1(int idSecuenciaIncoming){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR1(idSecuenciaIncoming).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"1" ,idSecuenciaIncoming));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR3 buscarPorIdSecuenciaTCR3(int idSecuenciaIncoming){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR3(idSecuenciaIncoming).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"3",idSecuenciaIncoming));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR4 buscarPorIdSecuenciaTCR4(int idSecuenciaIncoming){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR4(idSecuenciaIncoming).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"4" ,idSecuenciaIncoming));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTCR5 buscarPorIdSecuenciaTCR5(int idSecuenciaIncoming){
		return this.incomingVisaMapper.buscarPorIdSecuenciaTCR5(idSecuenciaIncoming).orElseThrow(
				() -> new RecursoNoEncontradoException(TRCX_NO_ENCONTRADO,"5" ,idSecuenciaIncoming));
	}
	
}
