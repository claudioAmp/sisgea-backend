package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.binvisa.BINVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.binvisa.CriterioBusquedaBinVisa;

@Mapper
public interface IBINVisaMapper {

	Page<BINVisa> buscarPorCriterios(CriterioBusquedaBinVisa criterioPaginacion);
	
	List<BINVisa> buscarTodos();
	
}
