package ob.unibanca.sicf.mantenimientosgenerales.service.parametroconsulta;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ParametroConsulta;

import java.util.List;

public interface IParametroConsultaService extends IMantenibleService <ParametroConsulta> {

	List<ParametroConsulta> buscarTodosParametrosConsulta();
	
}
