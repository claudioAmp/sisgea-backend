package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.pmp.CriterioBusquedaPMP;
import ob.unibanca.sicf.consultasgenerales.model.pmp.PMP;

@Mapper
public interface IPMPMapper {
	
	Page<PMP> buscarPorCriterios(CriterioBusquedaPMP criterioPaginacion);
	
	List<PMP> buscarTodos();
	
}
