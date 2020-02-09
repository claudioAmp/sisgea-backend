package edu.taller.sisgea.consultasgenerales.service.outgoingvisa.tc5;


import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR0;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR1;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR5;



public interface IOutgoingVisaTC5Service {
	
	Page<OutgoingVisaTC5> buscaPorCriteriosTC5PorPagina(CriterioBusquedaOutgoingVisaTC5 criterioBusqueda, int pageNo, int pageSize);
	
	OutgoingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaOutgoingVisa criterio);
}
