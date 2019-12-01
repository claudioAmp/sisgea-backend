package ob.unibanca.sicf.consultasgenerales.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinvisa.CriterioBusquedaRangoBinVisa;
import ob.unibanca.sicf.consultasgenerales.model.rangobinvisa.RangoBINVisa;

@Mapper
public interface IRangoBINVisaMapper {

	Page<RangoBINVisa> buscarPorCriterios(CriterioBusquedaRangoBinVisa criterioPaginacion);
	
	List<RangoBINVisa> buscarTodos();
}