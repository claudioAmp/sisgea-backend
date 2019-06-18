package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CategoriaNegocio;



@Mapper
public interface ICategoriaNegocioMapper extends IMantenibleMapper<CategoriaNegocio>{
	List<CategoriaNegocio> buscarTodos();
}
