package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import ob.unibanca.sicf.consultasgenerales.model.incomingIATA.IncomingIATA;

@Mapper
public interface IIncomingIATAMapper {
	
	List<IncomingIATA> buscarTodos();
	
	Page<IncomingIATA> buscarPorCriterios (CriterioBusquedaIncomingIATA criterioPaginacion);
	
}
