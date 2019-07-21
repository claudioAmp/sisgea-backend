package ob.unibanca.sicf.generadorconsultas.service.tablaforanea;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ITablasForaneasMapper;
import ob.unibanca.sicf.generadorconsultas.model.TablasForaneas;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablasForaneas;



@Service
public class TablasForaneasService extends MantenibleService<TablasForaneas> implements ITablasForaneasService {
	
	private final ITablasForaneasMapper tablasForaneasMapper;
	
	public TablasForaneasService(@Qualifier("ITablasForaneasMapper") IMantenibleMapper<TablasForaneas> mantenibleMapper) {
		super(mantenibleMapper);
		this.tablasForaneasMapper = (ITablasForaneasMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablasForaneas> buscarTodosTablasForaneas() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablasForaneas> buscarPorCriteriosTablasForaneas(CriterioBusquedaTablasForaneas criterio) {
		List<TablasForaneas> resultAux = new ArrayList<>(); 
		TablasForaneas aux = new TablasForaneas();
		List<TablasForaneas> result = this.tablasForaneasMapper.buscarPorCriterios(criterio);
		System.out.println(result);
		if(criterio.getPermited()==1) {
			criterio.setUsuario(UsuarioUtil.obtenerUsername());
		}
		if(criterio.getBidireccional()==1 && criterio.getIdTabla()!=0) {
			for(TablasForaneas t : result) {
				if(t.getIdTablaForanea()==criterio.getIdTabla() && t.getIdTabla()!=criterio.getIdTabla()) {
					aux = new TablasForaneas();
					aux.setIdTabla(t.getIdTablaForanea());
					aux.setTabla(t.getTablaForanea());
					aux.setAliasTabla(t.getAliasTablaForanea());
					aux.setIdCampo(t.getIdCampoForaneo());
					aux.setCampo(t.getCampoForaneo());
					aux.setAliasCampo(t.getAliasCampoForaneo());
					
					aux.setIdTablaForanea(t.getIdTabla());
					aux.setTablaForanea(t.getTabla());
					aux.setAliasTablaForanea(t.getAliasTabla());
					aux.setIdCampoForaneo(t.getIdCampo());
					aux.setCampoForaneo(t.getCampo());
					aux.setAliasCampoForaneo(t.getAliasCampo());
					t=aux;
				}
				resultAux.add(t);
			}
			result=resultAux;
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablasForaneas registrarTablasForaneas(TablasForaneas tablaForanea) {
		this.registrar(tablaForanea);
		tablaForanea=this.buscarTablaForaneaPorId(tablaForanea.getIdRelacionTablaFk());
		
		return tablaForanea;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TablasForaneas buscarTablaForaneaPorId(Integer idRelacionTablaFk) {
		CriterioBusquedaTablasForaneas criterio = new CriterioBusquedaTablasForaneas();
		criterio.setIdRelacionTablaFk(idRelacionTablaFk);
		return this.tablasForaneasMapper.buscarPorCriterios(criterio).get(0);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablasForaneas actualizarTablasForaneas(int idRelacionTablaFk, TablasForaneas tablaForanea) {
		tablaForanea.setIdRelacionTablaFk(idRelacionTablaFk);
		this.actualizar(tablaForanea);
		return this.buscarTablaForaneaPorId(idRelacionTablaFk);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTablasForaneas(int idRelacionTablaFk) {
		TablasForaneas tablaForanea = TablasForaneas.builder().idRelacionTablaFk(idRelacionTablaFk).build();
		this.eliminar(tablaForanea);
	}
}
