package edu.taller.sisgea.mantenimientosgenerales.service.parametroconsulta;

import edu.taller.sisgea.mantenimientosgenerales.model.ParametroConsulta;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IParametroConsultaService extends IMantenibleService <ParametroConsulta> {

	List<ParametroConsulta> buscarTodosParametrosConsulta();
	
}
