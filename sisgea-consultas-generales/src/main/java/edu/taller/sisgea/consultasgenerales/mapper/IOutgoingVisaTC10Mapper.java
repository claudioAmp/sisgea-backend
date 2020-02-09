package edu.taller.sisgea.consultasgenerales.mapper;



import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC10TCR0;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.outgoingvisa.OutgoingVisaTC10TCR0;


@Mapper
public interface IOutgoingVisaTC10Mapper {
	Page<OutgoingVisaTC10TCR0> buscarPorCriteriosTCR0(CriterioBusquedaOutgoingVisaTC10 criterioPaginacion);
	
	
}
