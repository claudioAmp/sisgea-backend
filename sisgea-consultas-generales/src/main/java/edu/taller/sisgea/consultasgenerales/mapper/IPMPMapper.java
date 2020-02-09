package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.pmp.CriterioBusquedaPMP;
import edu.taller.sisgea.consultasgenerales.model.pmp.PMP;

@Mapper
public interface IPMPMapper {
	
	Page<PMP> buscarPorCriterios(CriterioBusquedaPMP criterioPaginacion);
	
	List<PMP> buscarTodos();
	
}
