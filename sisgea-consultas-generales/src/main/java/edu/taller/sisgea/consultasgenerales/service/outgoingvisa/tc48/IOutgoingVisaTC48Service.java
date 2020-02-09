package edu.taller.sisgea.consultasgenerales.service.outgoingvisa.tc48;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR1;



public interface IOutgoingVisaTC48Service {
	
	public Page<OutgoingVisaTC48> buscaPorCriteriosPaginado(CriterioBusquedaOutgoingVisaTC48 criterioBusqueda, int pageNo, int pageSize);
	
	public OutgoingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaOutgoingVisa criterio);
	
	public OutgoingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaOutgoingVisa criterio);
}
