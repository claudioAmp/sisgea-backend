package edu.taller.sisgea.mantenimientosgenerales.service.parametrosistema;

import edu.taller.sisgea.mantenimientosgenerales.model.ParametroSistema;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IParametroSistemaService extends IMantenibleService <ParametroSistema> {

	List<ParametroSistema> buscarTodosParametrosSistema();
	
	ParametroSistema actualizarParametroSistema(ParametroSistema parametroSistema);
}
