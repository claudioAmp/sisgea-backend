package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0Det;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;

@Mapper
public interface IIncomingVisaTC48Mapper {
	
	Page<IncomingVisaTC48TCR0> buscarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTC48 criterioPaginacion);
	
	Optional<IncomingVisaTC48TCR0Det> buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTC48TCR1> buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
}
