package ob.unibanca.sicf.consultasgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import ob.unibanca.sicf.consultasgenerales.model.incomingIATAS.IncomingIATAS;

@Mapper
public interface IIncomingIATASMapper {
	
	Page<IncomingIATAS> buscarPorCriterios(CriterioBusquedaIncomingIATAS criterioPaginacion); 
	
}
