package edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc10;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;


public interface IIncomingVisaTC10Service {
	public Page<IncomingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(
            CriterioBusquedaIncomingVisaTC10 criterioBusqueda, int pageNo, int pageSize);
	
	
}
