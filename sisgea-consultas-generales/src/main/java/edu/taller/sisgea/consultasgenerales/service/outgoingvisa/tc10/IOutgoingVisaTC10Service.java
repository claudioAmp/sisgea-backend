package edu.taller.sisgea.consultasgenerales.service.outgoingvisa.tc10;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC10TCR0;


public interface IOutgoingVisaTC10Service {
	public Page<OutgoingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(
			CriterioBusquedaOutgoingVisaTC10 criterioBusqueda, int pageNo, int pageSize);
	
	
}
