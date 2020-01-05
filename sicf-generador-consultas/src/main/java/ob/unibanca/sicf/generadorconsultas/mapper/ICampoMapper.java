package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaConjuntoCampo;


@Mapper
public interface ICampoMapper extends IMantenibleMapper<Campo>{
	List<Campo> buscarTodos();
	Campo buscarPorId(int idCampo);
	List<Campo> buscarIdTabla(int idTabla);
	List<Campo> buscarPorCriterios(CriterioBusquedaCampo criterio);
	List<Campo> buscarConjuntoCampos(CriterioBusquedaConjuntoCampo criterio);
}
