package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR3;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;


@Mapper
public interface IIncomingVisaTC5Mapper {
	
	Page<IncomingVisaTC5> buscarPorCriteriosTC5(CriterioBusquedaIncomingVisaTC5 criterioPaginacion);
	
	IncomingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR3 buscarPorIdSecuenciaTC5TCR3(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR4 buscarPorIdSecuenciaTC5TCR4(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaIncomingVisa criterio);

}
