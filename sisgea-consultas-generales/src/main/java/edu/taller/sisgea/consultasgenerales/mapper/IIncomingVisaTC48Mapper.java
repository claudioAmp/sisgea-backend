package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.Optional;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;

@Mapper
public interface IIncomingVisaTC48Mapper {
	
	Page<IncomingVisaTC48> buscarPorCriterios(CriterioBusquedaIncomingVisaTC48 criterioPaginacion);
	
	IncomingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
}
