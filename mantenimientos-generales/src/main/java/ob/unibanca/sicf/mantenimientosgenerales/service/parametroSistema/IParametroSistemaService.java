package ob.unibanca.sicf.mantenimientosgenerales.service.parametroSistema;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ParametroSistema;

public interface IParametroSistemaService extends IMantenibleService <ParametroSistema> {

	List<ParametroSistema> buscarTodosParametrosSistema();
	
	ParametroSistema actualizarParametroSistema(ParametroSistema parametroSistema);
}
