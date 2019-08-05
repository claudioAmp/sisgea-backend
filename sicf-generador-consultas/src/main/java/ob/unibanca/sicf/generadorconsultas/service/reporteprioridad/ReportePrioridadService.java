package ob.unibanca.sicf.generadorconsultas.service.reporteprioridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IReportePrioridadMapper;
import ob.unibanca.sicf.generadorconsultas.model.Perfil;
import ob.unibanca.sicf.generadorconsultas.model.ReportePrioridad;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReportePrioridad;


@Service
public class ReportePrioridadService extends MantenibleService<ReportePrioridad> implements IReportePrioridadService {
	
	private final IReportePrioridadMapper reportePrioridadMapper;
	public ReportePrioridadService(@Qualifier("IReportePrioridadMapper") IMantenibleMapper<ReportePrioridad> mantenibleMapper) {
		super(mantenibleMapper);
		this.reportePrioridadMapper = (IReportePrioridadMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ReportePrioridad> buscarTodosReportesPrioridades() {
		return this.reportePrioridadMapper.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ReportePrioridad> buscarPorCriterioReportesPrioridades(CriterioBusquedaReportePrioridad criterio) {
		return this.reportePrioridadMapper.buscarPorCriterios(criterio);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ReportePrioridad registrarReportePrioridad(ReportePrioridad reporte) {
		this.registrar(reporte);
		return reporte;
	}
	
	@Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
	public ReportePrioridad actualizarReportePrioridad(int idQueryUsua,ReportePrioridad reporte) {
		reporte.setIdQueryUsua(idQueryUsua);
		this.actualizar(reporte);
		return reporte;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarReportePrioridad(int idQueryUsua) {
		ReportePrioridad reportePrioridad = ReportePrioridad.builder().idQueryUsua(idQueryUsua).build();
		this.eliminar(reportePrioridad);
	}
	
}

