package ob.unibanca.sicf.reportes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.reportes.model.CampoPerfil;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaCampoPerfil;
import ob.unibanca.sicf.reportes.service.campoperfil.CampoPerfilService;

@Mapper
public interface ICampoPerfilMapper extends IMantenibleMapper<CampoPerfil>{
	
	List<CampoPerfil> buscarTodos();
	
	List<CampoPerfil> buscarPorCriterios(CriterioBusquedaCampoPerfil criterio);
}
