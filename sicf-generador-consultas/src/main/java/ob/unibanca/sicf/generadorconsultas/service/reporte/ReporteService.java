package ob.unibanca.sicf.generadorconsultas.service.reporte;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IReporteMapper;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;
import ob.unibanca.sicf.generadorconsultas.model.UltimoSecuencia;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;
import ob.unibanca.sicf.generadorconsultas.service.campoquery.ICampoQueryService;
import ob.unibanca.sicf.generadorconsultas.service.tablaquery.ITablaQueryService;
import ob.unibanca.sicf.generadorconsultas.service.tablaquery.TablaQueryService;
import ob.unibanca.sicf.generadorconsultas.service.ultimosecuencia.IUltimoSecuenciaService;

import java.util.Map;
import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;


@Service
public class ReporteService extends MantenibleService<Reporte> implements IReporteService {
	
	private final IReporteMapper reporteMapper;
	private @Autowired final ITablaQueryService tablaQueryService;
	private @Autowired final ICampoQueryService campoQueryService;
	private @Autowired final IUltimoSecuenciaService ultimoSecuenciaService;
	
	public ReporteService(@Qualifier("IReporteMapper") IMantenibleMapper<Reporte> mantenibleMapper,ITablaQueryService tablaQueryService,ICampoQueryService campoQueryService,IUltimoSecuenciaService ultimoSecuenciaService) {
		super(mantenibleMapper);
		this.reporteMapper = (IReporteMapper) mantenibleMapper;
		this.tablaQueryService=tablaQueryService;
		this.ultimoSecuenciaService=ultimoSecuenciaService;
		this.campoQueryService=campoQueryService;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Reporte> buscarTodosReportes() {
		List<Reporte> reportes = this.buscarTodos();
		CriterioBusquedaTablaQuery criterioTabla = new CriterioBusquedaTablaQuery();
		CriterioBusquedaCampoQuery criterioCampo = new CriterioBusquedaCampoQuery();
		for(Reporte r : reportes) {
			criterioTabla.setIdReporte(r.getIdReporte());
			criterioCampo.setIdReporte(r.getIdReporte());
			r.setTablas(this.tablaQueryService.buscarPorCriteriosTablaQuery(criterioTabla));
			r.setCampos(this.campoQueryService.buscarPorCriteriosCamposQuery(criterioCampo));
		}
		return reportes;
		
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Reporte> buscarPorCriteriosReporte(CriterioBusquedaReporte criterio) {
		List<Reporte> reportes = this.reporteMapper.buscarPorCriterios(criterio);
		CriterioBusquedaTablaQuery criterioTabla = new CriterioBusquedaTablaQuery();
		CriterioBusquedaCampoQuery criterioCampo = new CriterioBusquedaCampoQuery();
		for(Reporte r : reportes) {
			criterioTabla.setIdReporte(r.getIdReporte());
			criterioCampo.setIdReporte(r.getIdReporte());
			r.setTablas(this.tablaQueryService.buscarPorCriteriosTablaQuery(criterioTabla));
			r.setCampos(this.campoQueryService.buscarPorCriteriosCamposQuery(criterioCampo));
		}
		return reportes;
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> ejecutarConsulta(String consulta) {
		Map<String, String> map = new HashMap<>();
		map.put("consulta", consulta);
		return reporteMapper.ejecutarConsulta(map);
	}
	// Registrar reporte 
	public void registrarReporteTotal(Reporte Reporte) {
		UltimoSecuencia ultSeq= this.ultimoSecuenciaService.obtenerUltimoSecuencia("REPORTE");
		int idReporte=ultSeq.getValor().intValue();
		Reporte.setIdReporte(idReporte);
		this.registrarReporte(Reporte);
		int idxTabla=0,idxCampo=0;
		for(TablaQuery t : Reporte.getTablas()) {
			ultSeq= this.ultimoSecuenciaService.obtenerUltimoSecuencia("TABLA_QUERY");
			t.setIdTablaQuery(ultSeq.getValor().intValue());
			t.setIdReporte(idReporte);
			Reporte.getTablas().set(idxTabla, t);
			this.tablaQueryService.registrar(t);
			idxTabla++;
		}
		for(CampoQuery c : Reporte.getCampos()) {
			ultSeq= this.ultimoSecuenciaService.obtenerUltimoSecuencia("CAMPO_QUERY");
			TablaQuery t = this.getTablaQuery(Reporte.getTablas(),c.getIdTabla(),c.getIdInstanciaTabla());
			if(t!=null) {
				c.setIdTablaQuery(t.getIdTablaQuery());
				c.setIdCampoQuery(ultSeq.getValor().intValue());
				c.setIdReporte(idReporte);
				Reporte.getCampos().set(idxCampo, c);
				this.campoQueryService.registrar(c);
			}
			idxCampo++;
		}
	}
	public TablaQuery getTablaQuery(List<TablaQuery> tablas, int idTabla,String instancia) {
		TablaQuery tq=null;
		for(int i=0;i<tablas.size();i++) {
			if(tablas.get(i).getIdTabla()==idTabla&&tablas.get(i).getIdInstancia().compareTo(instancia)==0) {
				return tablas.get(i);
			}
		}
		return tq;
	}
	
	

}

