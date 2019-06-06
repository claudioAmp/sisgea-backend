package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;


@Mapper
public interface ICampoPerfilMapper extends IMantenibleMapper<CampoPerfil>{
	
	List<CampoPerfil> buscarTodos();
	
	List<CampoPerfil> buscarPorCriterios(CriterioBusquedaCampoPerfil criterio);
	
	void actualizarCamposDePerfil(int idPerfil,String listaModificacion,String usuario);
}
