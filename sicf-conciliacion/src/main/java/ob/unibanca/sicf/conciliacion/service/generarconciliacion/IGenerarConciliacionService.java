package ob.unibanca.sicf.conciliacion.service.generarconciliacion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.conciliacion.model.GenerarConciliacion;

import java.util.List;

public interface IGenerarConciliacionService extends IMantenibleService<GenerarConciliacion> {

    List<GenerarConciliacion> buscarTodosGenerarConciliacions();

	List<GenerarConciliacion> buscarCamposTablaObservada();
	
	public GenerarConciliacion generarConciliacion(GenerarConciliacion generarConciliacion);

	public GenerarConciliacion buscarPorIdConcTabla(Integer idConcTabla);
    
}
