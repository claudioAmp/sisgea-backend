package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.ReportePrioridad;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaReportePrioridad;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface IReportePrioridadMapper extends IMantenibleMapper<ReportePrioridad>{
	
	List<ReportePrioridad> buscarTodos();

	List<ReportePrioridad> buscarPorCriterios(CriterioBusquedaReportePrioridad criterio);
	
}
