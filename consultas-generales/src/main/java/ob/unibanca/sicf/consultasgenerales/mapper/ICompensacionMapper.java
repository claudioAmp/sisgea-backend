package ob.unibanca.sicf.consultasgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.Compensacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion.CriterioCompensacion;

@Mapper
public interface ICompensacionMapper {
		
	public Page<Compensacion> buscarPorCriterios(CriterioCompensacion criterioPaginacion);
	
}
