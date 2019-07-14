package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampo;


@Mapper
public interface ICampoMapper extends IMantenibleMapper<Campo>{
	List<Campo> buscarTodos();
	Campo buscarPorId(int idCampo);
	List<Campo> buscarPorCriterios(CriterioBusquedaCampo criterio);
}
