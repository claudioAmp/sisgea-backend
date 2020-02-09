package edu.taller.sisgea.consultasgenerales.mapper;
import java.util.List;

import edu.taller.sisgea.consultasgenerales.model.criterio.rangobinvisa.CriterioBusquedaRangoBinVisa;
import edu.taller.sisgea.consultasgenerales.model.rangobinvisa.RangoBINVisa;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.rangobinvisa.CriterioBusquedaRangoBinVisa;
import edu.taller.sisgea.consultasgenerales.model.rangobinvisa.RangoBINVisa;

@Mapper
public interface IRangoBINVisaMapper {

	Page<RangoBINVisa> buscarPorCriterios(CriterioBusquedaRangoBinVisa criterioPaginacion);
	
	List<RangoBINVisa> buscarTodos();
}