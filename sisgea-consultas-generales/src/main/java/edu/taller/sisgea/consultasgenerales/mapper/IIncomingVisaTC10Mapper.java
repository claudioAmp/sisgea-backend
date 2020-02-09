package edu.taller.sisgea.consultasgenerales.mapper;



import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;


import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;


@Mapper
public interface IIncomingVisaTC10Mapper {
	Page<IncomingVisaTC10TCR0> buscarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTC10 criterioPaginacion);
	
	
}
