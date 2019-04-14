package ob.unibanca.sicf.consultasgenerales.service.incomingvisa;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaTCRXMapper;
import ob.unibanca.sicf.consultasgenerales.model.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
//import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.filtro.FiltroDtIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.utilitario.PaginacionUtils;

@Service
public class IncomingVisaTCRXService implements IIncomingVisaTCRXService{
	
	IIncomingVisaTCRXMapper incomingVisaTCR0;
	
	public IncomingVisaTCRXService(IIncomingVisaTCRXMapper incomingVisaTCR0) {
		this.incomingVisaTCR0 = incomingVisaTCR0;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<IncomingVisaTCR0> buscarTodosIncomingVisaTCR0( 
			CriterioPaginacion<CriterioBusquedaIncomingVisaTCR0> criterioPaginacion) {
		
			//criterioPaginacion.setOrderExpression(PaginacionUtils.obtenerExpresionOrdenamiento(criterioPaginacion));
			//criterioPaginacion.setFiltrosDatatable(PaginacionUtil.armarFiltroDatatable(criterioPaginacion));
			incomingVisaTCR0.buscarTodosTCR0(criterioPaginacion);
			
			
			//List<IncomingVisaTCR0> data =(List<IncomingVisaTCR09>)criterioPaginacion.getResultados();
    	return null;
	}

	
}
