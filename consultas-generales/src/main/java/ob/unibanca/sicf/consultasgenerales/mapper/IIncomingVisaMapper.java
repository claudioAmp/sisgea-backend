package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR5;


@Mapper
public interface IIncomingVisaMapper {
	
	Page<IncomingVisaTCR0> buscarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTCR0 criterioPaginacion);
	
	Optional<IncomingVisaTCR0> buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTCR1> buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTCR3> buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTCR4> buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio);
	
	Optional<IncomingVisaTCR5> buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio);

}
