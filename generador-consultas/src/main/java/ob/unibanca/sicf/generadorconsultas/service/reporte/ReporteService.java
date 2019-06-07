package ob.unibanca.sicf.generadorconsultas.service.reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IReporteMapper;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;


@Service
public class ReporteService extends MantenibleService<Reporte> implements IReporteService {
	
	private final IReporteMapper ReporteMapper;
	public ReporteService(@Qualifier("IReporteMapper") IMantenibleMapper<Reporte> mantenibleMapper) {
		super(mantenibleMapper);
		this.ReporteMapper = (IReporteMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Reporte> buscarTodosReportes() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Reporte> buscarPorCriteriosReporte(CriterioBusquedaReporte criterio) {
		return this.ReporteMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Reporte registrarReporte(Reporte Reporte) {
		this.registrar(Reporte);
		return Reporte;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Reporte actualizarReporte(int idReporte, Reporte Reporte) {
		Reporte.setIdReporte(idReporte);
		this.actualizar(Reporte);
		return Reporte;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarReporte(int idReporte) {
		Reporte reporte = Reporte.builder().idReporte(idReporte).build();
		this.eliminar(reporte);
	}

}

