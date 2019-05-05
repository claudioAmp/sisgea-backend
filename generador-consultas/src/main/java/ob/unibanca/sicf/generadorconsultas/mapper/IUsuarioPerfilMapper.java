package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.UsuarioPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaUsuarioPerfil;


@Mapper
public interface IUsuarioPerfilMapper extends IMantenibleMapper<UsuarioPerfil>{
	
	List<UsuarioPerfil> buscarTodos();
	
	List<UsuarioPerfil> buscarPorCriterios(CriterioBusquedaUsuarioPerfil criterio);
}
