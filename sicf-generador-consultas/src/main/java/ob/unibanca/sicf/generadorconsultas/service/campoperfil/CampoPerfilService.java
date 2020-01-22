package ob.unibanca.sicf.generadorconsultas.service.campoperfil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ICampoPerfilMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaPerfilCampoActualizarMasivo;

@Service
public class CampoPerfilService extends MantenibleService<CampoPerfil> implements ICampoPerfilService {
	
	private final ICampoPerfilMapper campoPerfilMapper;
	private static final String UPDATE_SUCCESS = "Recursos asociados al perfil correctamente";
	
	public CampoPerfilService(@Qualifier("ICampoPerfilMapper") IMantenibleMapper<CampoPerfil> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoPerfilMapper = (ICampoPerfilMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoPerfil> buscarTodosCampoPerfil() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoPerfil> buscarPorCriteriosCampoPerfil(CriterioBusquedaCampoPerfil criterio) {
		return this.campoPerfilMapper.buscarPorCriterios(criterio);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoPerfil> buscarCamposAsignables(CriterioBusquedaCampoPerfil criterio) {
		return this.campoPerfilMapper.buscarCamposAsignables(criterio);
	}	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoPerfil registrarCampoPerfil(CampoPerfil campoPerfil) {
		this.registrar(campoPerfil);
		return campoPerfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoPerfil actualizarCampoPerfil(int idPerfilRepCampo, CampoPerfil campoPerfil) {
		campoPerfil.setIdPerfilRepCampo(idPerfilRepCampo);
		this.actualizar(campoPerfil);
		return campoPerfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCampoPerfil(int idCampoPerfil) {
		CampoPerfil campoPerfil = CampoPerfil.builder().idPerfilRepCampo(idCampoPerfil).build();
		this.eliminar(campoPerfil);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void actualizarCamposDePerfil(int idPerfil, String listaModificacion, String usuario) {
		this.campoPerfilMapper.actualizarCamposDePerfil(idPerfil, listaModificacion, usuario);
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void actualizarCamposDePerfilMasivo(CriterioBusquedaPerfilCampoActualizarMasivo criterio) {
		List<CampoPerfil> lista =  new ArrayList<>();
		Integer idPerfil = criterio.getIdPerfil();
		criterio.getListaModificacion().forEach((perfilCampo)->{
			Set<String> keys = perfilCampo.keySet();
			String idTabla="";
			for(String key: keys){
				idTabla = key;
	        }
			String[] idsCampos = perfilCampo.get(idTabla).split("-");
			for(String idCampo: idsCampos){
				CampoPerfil campo = CampoPerfil.builder()
						.idTabla(Integer.valueOf(idTabla))
						.idCampo(Integer.valueOf(idCampo))
						.idPerfil(idPerfil).build();
				lista.add(campo);
	        }
		});
		this.campoPerfilMapper.eliminarCamposDePerfilMasivo(idPerfil);
		this.campoPerfilMapper.registrarCamposDePerfilMasivo(lista);
	}
}