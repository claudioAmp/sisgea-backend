package ob.unibanca.sicf.consultasgenerales.service.incomingvisa;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;



@Service
public class IncomingVisaService implements IIncomingVisaService{
	
	IIncomingVisaMapper incomingVisaTCR0;
	
	public IncomingVisaService(IIncomingVisaMapper incomingVisaTCR0) {
		this.incomingVisaTCR0 = incomingVisaTCR0;
	}
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTCR0> buscaPorCriterios(CriterioBusquedaIncomingVisaTCR0 criterioBusqueda) {
		CriterioPaginacion<CriterioBusquedaIncomingVisaTCR0> criterioPaginacion= new CriterioPaginacion<>();
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		criterioPaginacion.setPageNo(50);
		criterioPaginacion.setPageSize(10);
		
		PageHelper.startPage(criterioPaginacion.getPageNo(), criterioPaginacion.getPageSize()); 

       return incomingVisaTCR0.buscarPorCriterios(criterioBusqueda); 
    }

	
}
