package ob.unibanca.sicf.consultasgenerales.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR1;


@Mapper
public interface IOutgoingVisaTC48Mapper {
	
	Page<OutgoingVisaTC48> buscarPorCriterios(CriterioBusquedaOutgoingVisaTC48 criterioPaginacion);
	
	OutgoingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaOutgoingVisa criterio);
}
