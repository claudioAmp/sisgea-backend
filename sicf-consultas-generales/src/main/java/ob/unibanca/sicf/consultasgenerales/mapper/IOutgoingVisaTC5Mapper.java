package ob.unibanca.sicf.consultasgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR5;




@Mapper
public interface IOutgoingVisaTC5Mapper {
	
	Page<OutgoingVisaTC5> buscarPorCriteriosTC5(CriterioBusquedaOutgoingVisaTC5 criterioPaginacion);
	
	OutgoingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaOutgoingVisa criterio);
	
	OutgoingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaOutgoingVisa criterio);

}
