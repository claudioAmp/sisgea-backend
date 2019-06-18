package ob.unibanca.sicf.generadorconsultas.service.parametrorep;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IParametroRepMapper;
import ob.unibanca.sicf.generadorconsultas.model.ParametroRep;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaParametroRep;


@Service
public class ParametroRepService extends MantenibleService<ParametroRep> implements IParametroRepService {
	
	private final IParametroRepMapper ParametroRepMapper;
	public ParametroRepService(@Qualifier("IParametroRepMapper") IMantenibleMapper<ParametroRep> mantenibleMapper) {
		super(mantenibleMapper);
		this.ParametroRepMapper = (IParametroRepMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ParametroRep> buscarTodosParametrosRep() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ParametroRep> buscarPorCriteriosParametroRep(CriterioBusquedaParametroRep criterio) {
		return this.ParametroRepMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ParametroRep registrarParametroRep(ParametroRep ParametroRep) {
		this.registrar(ParametroRep);
		return ParametroRep;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ParametroRep actualizarParametroRep(int IdParametro, ParametroRep ParametroRep) {
		ParametroRep.setIdParametro(IdParametro);
		this.actualizar(ParametroRep);
		return ParametroRep;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarParametroRep(int IdParametro) {
		ParametroRep parametroRep = ParametroRep.builder().idParametro(IdParametro).build();
		this.eliminar(parametroRep);
	}
}

