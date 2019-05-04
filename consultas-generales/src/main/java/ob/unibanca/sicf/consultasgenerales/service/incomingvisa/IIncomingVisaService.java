package ob.unibanca.sicf.consultasgenerales.service.incomingvisa;


import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR5;

public interface IIncomingVisaService {
	
	Page<IncomingVisaTCR0> buscaPorCriteriosTCR0(
			CriterioBusquedaIncomingVisaTCR0 criterioPaginacion);
		
	Page<IncomingVisaTCR0> buscaPorCriteriosTCR0PorPagina(
			CriterioBusquedaIncomingVisaTCR0 criterioBusqueda,int pageNo, int pageSize);
	
	IncomingVisaTCR1 buscarPorIdSecuenciaTCR1(int idSecuenciaIncoming);
	
	IncomingVisaTCR3 buscarPorIdSecuenciaTCR3(int idSecuenciaIncoming);
	
	IncomingVisaTCR4 buscarPorIdSecuenciaTCR4(int idSecuenciaIncoming);
	
	IncomingVisaTCR5 buscarPorIdSecuenciaTCR5(int idSecuenciaIncoming);
}
