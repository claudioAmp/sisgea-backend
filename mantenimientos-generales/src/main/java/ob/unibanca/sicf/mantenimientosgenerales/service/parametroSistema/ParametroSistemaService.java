package ob.unibanca.sicf.mantenimientosgenerales.service.parametroSistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IParametroSistemaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ParametroSistema;

@Service
public class ParametroSistemaService extends MantenibleService<ParametroSistema> implements IParametroSistemaService {

	private static final String PARAMETRO_SISTEMA_NO_ENCONTRADO = "Parámetros Sistema no encontrados.";
	@SuppressWarnings("unused")
	private final IParametroSistemaMapper parametroSistemaMapper;
	
	public ParametroSistemaService(@Qualifier("IParametroSistemaMapper") IMantenibleMapper<ParametroSistema> mantenibleMapper) {
		super(mantenibleMapper);
		this.parametroSistemaMapper = (IParametroSistemaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ParametroSistema> buscarTodosParametrosSistema(){
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ParametroSistema actualizarParametroSistema(ParametroSistema parametroSistema) {
		this.actualizar(parametroSistema);
		return this.buscarTodosParametrosSistema().stream().findFirst()
				.orElseThrow(() -> new RecursoNoEncontradoException(PARAMETRO_SISTEMA_NO_ENCONTRADO));
	}
}
