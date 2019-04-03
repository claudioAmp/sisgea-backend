package ob.unibanca.sicf.mantenimientosgenerales.service.parametrosistema;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ParametroSistema;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParametroSistemaService extends MantenibleService<ParametroSistema> implements IParametroSistemaService {
	
	private static final String PARAMETRO_SISTEMA_NO_ENCONTRADO = "Los parámetros sistema no existen.";
	
	public ParametroSistemaService(
			@Qualifier("IParametroSistemaMapper") IMantenibleMapper<ParametroSistema> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ParametroSistema> buscarTodosParametrosSistema() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ParametroSistema actualizarParametroSistema(ParametroSistema parametroSistema) {
		this.actualizar(parametroSistema);
		return this.buscarTodosParametrosSistema().stream().findFirst().orElseThrow(
				() -> new RecursoNoEncontradoException(PARAMETRO_SISTEMA_NO_ENCONTRADO));
	}
}
