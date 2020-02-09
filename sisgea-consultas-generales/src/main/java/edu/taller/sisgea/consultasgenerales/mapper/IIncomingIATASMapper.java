package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import edu.taller.sisgea.consultasgenerales.model.incomingIATAS.IncomingIATAS;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import edu.taller.sisgea.consultasgenerales.model.incomingIATAS.IncomingIATAS;

@Mapper
public interface IIncomingIATASMapper {
	
	Page<IncomingIATAS> buscarPorCriterios(CriterioBusquedaIncomingIATAS criterioPaginacion);
	
}
