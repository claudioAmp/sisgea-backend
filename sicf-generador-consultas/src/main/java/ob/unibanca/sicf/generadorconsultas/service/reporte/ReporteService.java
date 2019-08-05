package ob.unibanca.sicf.generadorconsultas.service.reporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;
import ob.unibanca.sicf.generadorconsultas.model.UltimoSecuencia;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaFiltro;
import ob.unibanca.sicf.generadorconsultas.model.criterio.paginacion.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IReporteMapper;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;
import ob.unibanca.sicf.generadorconsultas.service.campoquery.ICampoQueryService;
import ob.unibanca.sicf.generadorconsultas.service.condicionquery.ICondicionQueryService;
import ob.unibanca.sicf.generadorconsultas.service.filtro.IFiltroService;
import ob.unibanca.sicf.generadorconsultas.service.generarconsulta.IGenerarConsultaService;
import ob.unibanca.sicf.generadorconsultas.service.tablaonjoin.ITablaOnJoinService;
import ob.unibanca.sicf.generadorconsultas.service.tablaquery.ITablaQueryService;
import ob.unibanca.sicf.generadorconsultas.service.ultimosecuencia.IUltimoSecuenciaService;

import java.util.Map;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.CondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;


@Service
public class ReporteService extends MantenibleService<Reporte> implements IReporteService {
	
	private @Autowired final IReporteMapper reporteMapper;
	private @Autowired ITablaQueryService tablaQueryService;
	private @Autowired ITablaOnJoinService tablaOnJoinService;
	private @Autowired ICampoQueryService campoQueryService;
	private @Autowired IFiltroService filtroService;
	private @Autowired ICondicionQueryService condicionService;
	private @Autowired IUltimoSecuenciaService ultimoSecuenciaService;
	private @Autowired IGenerarConsultaService generarConsultaService;
	
	public ReporteService(@Qualifier("IReporteMapper") IMantenibleMapper<Reporte> mantenibleMapper,ITablaQueryService tablaQueryService,ICampoQueryService campoQueryService,IUltimoSecuenciaService ultimoSecuenciaService) {
		super(mantenibleMapper);
		this.reporteMapper = (IReporteMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Reporte> buscarTodosReportes() {
		/*CriterioBusquedaReporte criterio = new CriterioBusquedaReporte();
		criterio.setPermited(1);
		return this.buscarPorCriteriosReporte(criterio);*/
		return this.buscarTodos();
		
		
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Reporte> buscarPorCriteriosReporte(CriterioBusquedaReporte criterio) {
		
		if(criterio.getPermited()==1) {
			criterio.setUsuario(UsuarioUtil.obtenerUsername().toUpperCase());
		}
		return this.reporteMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Reporte registrarReporte(Reporte Reporte) {
		this.registrar(Reporte);
		return Reporte;
	}
	
	@Override
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Reporte actualizarReporte(int idReporte, Reporte Reporte) {
		CriterioBusquedaReporte criterio= new CriterioBusquedaReporte();
		criterio.setIdReporte(idReporte);
		Reporte repAnt = this.reporteMapper.buscarPorCriterios(criterio).get(0);
		if(repAnt.getFrecuencia()+1==Reporte.getFrecuencia() || repAnt.getPrioridad()+1==Reporte.getPrioridad()) {
			System.out.println("Estoy actualizando +1 frecuencia : "+Reporte);
			this.actualizar(Reporte);
			return Reporte;
			
		}else {
			System.out.println("Estoy guardando cambios en : "+Reporte);
			this.eliminar(Reporte);
			System.out.println("Eliminé");
			return this.registrarReporteTotal(idReporte, Reporte);
		}
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarReporte(int idReporte) {
		Reporte reporte = Reporte.builder().idReporte(idReporte).build();
		this.eliminar(reporte);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Page<Map<String, Object>> ejecutarConsulta(String consulta, PageParameter pageParameter) {
		Map<String, String> map = new HashMap<>();
		map.put("consulta", consulta);
		PageHelper.startPage(pageParameter.getPageNum(), pageParameter.getPageSize());
		return reporteMapper.ejecutarConsulta(map);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> ejecutarConsulta(String consulta) {
		Map<String, String> map = new HashMap<>();
		map.put("consulta", consulta);
		return reporteMapper.ejecutarConsultaSinPaginar(map);
	}
	
	// Registrar reporte
	//@Transactional(propagation = Propagation.REQUIRED)
	public Reporte registrarReporteTotal(int idReporte,Reporte Reporte) {
		System.out.println(Reporte);
		int idxTabla=0,idxCampo=0,idxFiltro=0,idxTablaOnJoin=0,idxCondicion=0;
		List<List<Integer>> idConQAux= new ArrayList<>();
		if(idReporte!=0) {
			Reporte.setIdReporte(idReporte);
		}	
		Reporte.setPrioridad(0);
		Reporte.setQueryReporte(this.generarConsultaService.generarConsulta(Reporte));
		this.registrarReporte(Reporte);
		idReporte=Reporte.getIdReporte();
		for(TablaQuery t : Reporte.getTablas()) {
			t.setIdReporte(idReporte);
			Reporte.getTablas().set(idxTabla, t);
			this.tablaQueryService.registrar(t);
			idxTabla++;
		}
		for(CampoQuery c : Reporte.getCampos()) {
			TablaQuery t = this.getTablaQuery(Reporte.getTablas(),c.getIdTabla(),c.getIdInstanciaTabla());
			if(t!=null) {
				c.setIdTablaQuery(t.getIdTablaQuery());
				c.setIdReporte(idReporte);
				Reporte.getCampos().set(idxCampo, c);
				this.campoQueryService.registrar(c);
			}
			
			idxCampo++;
		}
		for(TablaOnJoin to :Reporte.getTablasOnJoin()) {
			System.out.println(to);
			CampoQuery c = this.getCampoQuery(Reporte.getCampos(),to.getIdCampoBase(), to.getInstanciaTablaBase());
			to.setIdReporte(idReporte);
			if(c!=null) {
				to.setIdCampoQueryBase(c.getIdCampoQuery());
			}
			c = this.getCampoQuery(Reporte.getCampos(),to.getIdCampoJoin(), to.getInstanciaTablaJoin());
			if(c!=null) {
				to.setIdCampoQueryJoin(c.getIdCampoQuery());
			}
			Reporte.getTablasOnJoin().set(idxTablaOnJoin, to);
			this.tablaOnJoinService.registrar(to);
			idxTablaOnJoin++;
		}
		for(CondicionQuery cq : Reporte.getCondiciones()) {
			cq.setIdReporte(idReporte);
			if( cq.getIdCondicionPadre()!=0) {
				cq.setIdCondicionPadre(this.getCondicionQuery(Reporte.getCondiciones(), cq.getIdCondicionPadre()).getIdCondicionQuery());
			}else {
				cq.setIdCondicionPadre(null);
			}
			Reporte.getCondiciones().set(idxCondicion, cq);
			this.condicionService.registrar(cq);
			idxCondicion++;
		}
		for(Filtro f : Reporte.getFiltros()) {
			CampoQuery c = this.getCampoQuery(Reporte.getCampos(),f.getIdCampo(), f.getIdInstancia());
			if(c!=null) {
				f.setIdCampoQuery(c.getIdCampoQuery());
				System.out.println(f);
				f.setIdCondicionPadre(this.getCondicionQuery(Reporte.getCondiciones(),f.getIdCondicionPadre()).getIdCondicionQuery());
				Reporte.getFiltros().set(idxFiltro, f);
				this.filtroService.registrar(f);
			}
			idxFiltro++;
		}
		System.out.println("Acabé de insertar");
		return this.buscarReporte(idReporte).get(0);
	}
	public TablaQuery getTablaQuery(List<TablaQuery> tablas, int idTabla,String instancia) {
		TablaQuery tq=null;
		for(int i=0;i<tablas.size();i++) {
			if(tablas.get(i).getIdTabla()==idTabla && tablas.get(i).getIdInstancia().equalsIgnoreCase(instancia)) {		
				return tablas.get(i);
			}
		}
		return tq;
	}
	public CampoQuery getCampoQuery(List<CampoQuery> campos, int idCampo,String instancia) {
		CampoQuery cq=null;
		System.out.println("idCampo:"+idCampo+",instancia:"+instancia);
		System.out.println(campos);
		for(int i=0;i<campos.size();i++) {
			if(campos.get(i).getIdCampo()==idCampo&&campos.get(i).getIdInstanciaTabla().equalsIgnoreCase(instancia)) {
				return campos.get(i);
			}
		}
		return cq;
	}
	public CondicionQuery getCondicionQuery(List<CondicionQuery> condiciones, int idCondAux) {
		CondicionQuery cq=null;
		for(int i=0;i<condiciones.size();i++) {
			if(condiciones.get(i).getIdCondicionQueryAux()==idCondAux) {
				return condiciones.get(i);
			}
		}
		return cq;
	}

	@Override
	public List<Reporte> buscarReporte(int idReporte) {
		CriterioBusquedaReporte criterio = new CriterioBusquedaReporte();
		List<TablaQuery> tablas= new ArrayList<>();
		List<CampoQuery> campos= new ArrayList<>();
		List<TablaOnJoin> tablasOnJoin= new ArrayList<>();
		List<Filtro> filtros= new ArrayList<>();
		List<CondicionQuery> condiciones= new ArrayList<>();
		//Obtener el reporte
		criterio.setIdReporte(idReporte);
		Reporte reporte =this.buscarPorCriteriosReporte(criterio).get(0);
		//Obtener tablas query del reporte
		CriterioBusquedaTablaQuery c1 = new CriterioBusquedaTablaQuery();
		c1.setIdReporte(idReporte);
		for(TablaQuery t : this.tablaQueryService.buscarPorCriteriosTablaQuery(c1)) {
			tablas.add(t);
		}
		reporte.setTablas(tablas);
		//obtener campos query del reporte
		CriterioBusquedaCampoQuery c2 = new CriterioBusquedaCampoQuery();
		c2.setIdReporte(idReporte);
		for(CampoQuery c : this.campoQueryService.buscarPorCriteriosCamposQuery(c2)) {
			campos.add(c);
		}
		reporte.setCampos(campos);
		//Obtener tablas on join
		CriterioBusquedaTablaOnJoin c3 = new CriterioBusquedaTablaOnJoin();
		c3.setIdReporte(idReporte);
		for(TablaOnJoin t : this.tablaOnJoinService.buscarPorCriteriosTablaOnJoin(c3)) {
			tablasOnJoin.add(t);
		}
		reporte.setTablasOnJoin(tablasOnJoin);
		//Obtener filtros
		CriterioBusquedaFiltro c4 = new CriterioBusquedaFiltro();
		c4.setIdReporte(idReporte);
		for(Filtro f : this.filtroService.buscarPorCriteriosFiltro(c4)) {
			filtros.add(f);
		}
		reporte.setFiltros(filtros);
		//Obtener filtros
		CriterioBusquedaCondicionQuery c5 = new CriterioBusquedaCondicionQuery();
		c5.setIdReporte(idReporte);
		for(CondicionQuery c : this.condicionService.buscarPorCriteriosCondicionQuery(c5)) {
			condiciones.add(c);
		}
		reporte.setCondiciones(condiciones);
		List<Reporte> result = new ArrayList<>();
		result.add(reporte);
		return result;
	}
	
	
	

}

