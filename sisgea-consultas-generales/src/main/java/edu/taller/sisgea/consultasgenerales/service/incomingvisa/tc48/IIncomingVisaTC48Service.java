package edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc48;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;

public interface IIncomingVisaTC48Service {
	
	public Page<IncomingVisaTC48> buscaPorCriteriosPaginado(CriterioBusquedaIncomingVisaTC48 criterioBusqueda, int pageNo, int pageSize);
	
	public IncomingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	public IncomingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
}
