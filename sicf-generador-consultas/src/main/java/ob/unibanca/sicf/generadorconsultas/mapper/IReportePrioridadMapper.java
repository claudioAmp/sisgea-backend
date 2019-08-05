package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.ReportePrioridad;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReportePrioridad;


@Mapper
public interface IReportePrioridadMapper extends IMantenibleMapper<ReportePrioridad>{
	
	List<ReportePrioridad> buscarTodos();

	List<ReportePrioridad> buscarPorCriterios(CriterioBusquedaReportePrioridad criterio);
	
}
