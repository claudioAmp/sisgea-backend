package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import edu.taller.sisgea.generadorconsultas.model.Reporte;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import java.util.Map;

@Mapper
public interface IReporteMapper extends IMantenibleMapper<Reporte>{
	
	List<Reporte> buscarTodos();
	
	List<Reporte> buscarPorCriterios(CriterioBusquedaReporte criterio);
	
	Page<Map<String, Object>> ejecutarConsulta(Map<String, String> consulta);
	
	List<Map<String, Object>> ejecutarConsultaSinPaginar(Map<String, String> consulta);
	
}
