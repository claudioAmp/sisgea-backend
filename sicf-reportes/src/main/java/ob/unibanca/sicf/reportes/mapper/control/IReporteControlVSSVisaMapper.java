package ob.unibanca.sicf.reportes.mapper.control;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.unibanca.sicf.reportes.model.control.ReporteControlVSSVisa;
import ob.unibanca.sicf.reportes.model.control.criterio.CriterioBusquedaReporteControlVSSVisa;

@Mapper
public interface IReporteControlVSSVisaMapper {
	List<ReporteControlVSSVisa> buscarPorFechaProceso(CriterioBusquedaReporteControlVSSVisa criterio);
}
