package ob.unibanca.sicf.reportes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.reportes.model.Perfil;

@Mapper
public interface IPerfilMapper extends IMantenibleMapper<Perfil>{
	List<Perfil> buscarTodos();
}
