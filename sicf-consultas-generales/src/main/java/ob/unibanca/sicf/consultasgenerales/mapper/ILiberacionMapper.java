package ob.unibanca.sicf.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.liberacion.Liberacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ILiberacionMapper {
	
	Page<Liberacion> buscarPorCriterios(CriterioBusquedaLiberacion criterioPaginacion);
	
}
