package ob.unibanca.sicf.consultasgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import ob.unibanca.sicf.consultasgenerales.model.irregular.Irregular;

@Mapper
public interface IIrregularMapper {


	public Page<Irregular> buscarPorCriteriosIrregulares(CriterioBusquedaIrregular criterio);

}
