package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.List;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import edu.taller.sisgea.consultasgenerales.model.incomingIATA.IncomingIATA;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import edu.taller.sisgea.consultasgenerales.model.incomingIATA.IncomingIATA;

@Mapper
public interface IIncomingIATAMapper {
	
	List<IncomingIATA> buscarTodos();
	
	Page<IncomingIATA> buscarPorCriterios (CriterioBusquedaIncomingIATA criterioPaginacion);
	
}
