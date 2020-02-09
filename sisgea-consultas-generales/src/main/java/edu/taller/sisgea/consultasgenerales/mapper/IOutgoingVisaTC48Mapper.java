package edu.taller.sisgea.consultasgenerales.mapper;


import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR1;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR1;


@Mapper
public interface IOutgoingVisaTC48Mapper {
	
	Page<OutgoingVisaTC48> buscarPorCriterios(CriterioBusquedaOutgoingVisaTC48 criterioPaginacion);
	
	OutgoingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaOutgoingVisa criterio);
}
