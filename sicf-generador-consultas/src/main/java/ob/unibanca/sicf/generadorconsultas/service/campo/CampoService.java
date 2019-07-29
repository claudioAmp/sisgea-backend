package ob.unibanca.sicf.generadorconsultas.service.campo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ICampoMapper;
import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaConjuntoCampo;


@Service
public class CampoService extends MantenibleService<Campo> implements ICampoService {
	
	private final ICampoMapper campoMapper;
	
	public CampoService(@Qualifier("ICampoMapper") IMantenibleMapper<Campo> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoMapper = (ICampoMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Campo> buscarTodosCampos() {
		return this.campoMapper.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Campo buscarPorId(int idCampo) {
		return this.campoMapper.buscarPorId(idCampo);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Campo> buscarPorCriteriosCampo(CriterioBusquedaCampo criterio) {
		return this.campoMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Campo> buscarConjuntoCampos(CriterioBusquedaConjuntoCampo criterio) {
		return this.campoMapper.buscarConjuntoCampos(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Campo registrarCampo(Campo Campo) {
		this.registrar(Campo);
		return Campo;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Campo actualizarCampo(int idCampo, Campo Campo) {
		Campo.setIdCampo(idCampo);
		this.actualizar(Campo);
		return Campo;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCampo(int idCampo) {
		Campo campo = Campo.builder().idCampo(idCampo).build();
		this.eliminar(campo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Campo> buscarCamposPorUsuarioActivo() {
		CriterioBusquedaCampo criterio = new CriterioBusquedaCampo();
		criterio.setUsuario(UsuarioUtil.obtenerUsername().toUpperCase());
		return this.campoMapper.buscarPorCriterios(criterio);
	}
}

