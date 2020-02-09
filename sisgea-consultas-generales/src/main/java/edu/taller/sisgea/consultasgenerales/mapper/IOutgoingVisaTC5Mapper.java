package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR0;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR1;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR5;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR0;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR1;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR5;




@Mapper
public interface IOutgoingVisaTC5Mapper {
	
	Page<OutgoingVisaTC5> buscarPorCriteriosTC5(CriterioBusquedaOutgoingVisaTC5 criterioPaginacion);
	
	OutgoingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaOutgoingVisa criterio);

}
