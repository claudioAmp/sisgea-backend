package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

@Mapper
public interface IIncomingVisaTC10Mapper {
	Page<IncomingVisaTC10TCR0> buscarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTC10 criterioPaginacion);
	
	
}
