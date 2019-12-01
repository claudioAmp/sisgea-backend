package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.binvisa.BINVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.binvisa.CriterioBusquedaBinVisa;

@Mapper
public interface IBINVisaMapper {

	Page<BINVisa> buscarPorCriterios(CriterioBusquedaBinVisa criterioPaginacion);
	
	List<BINVisa> buscarTodos();
	
}
