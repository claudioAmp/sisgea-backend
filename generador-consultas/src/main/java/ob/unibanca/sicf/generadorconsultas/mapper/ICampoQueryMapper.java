package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;


@Mapper
public interface ICampoQueryMapper extends IMantenibleMapper<CampoQuery>{
	List<CampoQuery> buscarTodos();
}
