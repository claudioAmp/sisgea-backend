package ob.unibanca.sicf.mantenimientosgenerales.service.parametrosistema;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ParametroSistema;

import java.util.List;

public interface IParametroSistemaService extends IMantenibleService <ParametroSistema> {

	List<ParametroSistema> buscarTodosParametrosSistema();
	
	ParametroSistema actualizarParametroSistema(ParametroSistema parametroSistema);
}
