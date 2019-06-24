package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0Det;
import ob.unibanca.sicf.consultasgenerales.util.pagination.EstructuraConsulta;

@Mapper
public interface IIncomingVisaTC10Mapper {
	Page<IncomingVisaTC10TCR0> buscarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTC10 criterioPaginacion);
	
	Optional<IncomingVisaTC10TCR0Det> buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	Page<IncomingVisaTC10TCR0> buscarPorCriteriosTCR0Aggrid(CriterioBusquedaIncomingVisaTC10 criterioPaginacion);
}
