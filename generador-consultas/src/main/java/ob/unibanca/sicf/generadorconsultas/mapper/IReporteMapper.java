package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;


@Mapper
public interface IReporteMapper extends IMantenibleMapper<Reporte>{
	List<Reporte> buscarTodos();
	List<Reporte> buscarPorCriterios(CriterioBusquedaReporte criterio);
	
}
