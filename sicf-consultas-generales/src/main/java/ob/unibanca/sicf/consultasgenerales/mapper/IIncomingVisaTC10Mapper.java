package ob.unibanca.sicf.consultasgenerales.mapper;



import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;


import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;


@Mapper
public interface IIncomingVisaTC10Mapper {
	Page<IncomingVisaTC10TCR0> buscarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTC10 criterioPaginacion);
	
	
}
