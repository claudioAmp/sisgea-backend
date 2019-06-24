package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisatTC5TCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;


@Mapper
public interface IIncomingVisaMapper {
	
	Page<IncomingVisaTC5TCR0> buscarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTCR0 criterioPaginacion);
	
	Optional<IncomingVisaTC5TCR0> buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTC5TCR1> buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisatTC5TCR3> buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTC5TCR4> buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTC5TCR5> buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio);

}
