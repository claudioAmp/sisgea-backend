package ob.unibanca.sicf.generadorconsultas.service.campo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ICampoMapper;
import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampo;


@Service
public class CampoService extends MantenibleService<Campo> implements ICampoService {
	
	private final ICampoMapper CampoMapper;
	public CampoService(@Qualifier("ICampoMapper") IMantenibleMapper<Campo> mantenibleMapper) {
		super(mantenibleMapper);
		this.CampoMapper = (ICampoMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Campo> buscarTodosCampos() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Campo> buscarPorCriteriosCampo(CriterioBusquedaCampo criterio) {
		return this.CampoMapper.buscarPorCriterios(criterio);
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
}

