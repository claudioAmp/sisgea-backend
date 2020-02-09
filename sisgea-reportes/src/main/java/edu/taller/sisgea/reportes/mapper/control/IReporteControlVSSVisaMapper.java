package edu.taller.sisgea.reportes.mapper.control;

import java.util.List;

import edu.taller.sisgea.reportes.model.control.criterio.CriterioBusquedaReporteControlVSSVisa;
import org.apache.ibatis.annotations.Mapper;

import edu.taller.sisgea.reportes.model.control.ReporteControlVSSVisa;

@Mapper
public interface IReporteControlVSSVisaMapper {
	List<ReporteControlVSSVisa> buscarPorFechaProceso(CriterioBusquedaReporteControlVSSVisa criterio);
}
