package edu.taller.sisgea.conciliacion.service.generarconciliacion;

import edu.taller.sisgea.conciliacion.model.GenerarConciliacion;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IGenerarConciliacionService extends IMantenibleService<GenerarConciliacion> {

    List<GenerarConciliacion> buscarTodosGenerarConciliacions();

	List<GenerarConciliacion> buscarCamposTablaObservada();
	
	public GenerarConciliacion generarConciliacion(GenerarConciliacion generarConciliacion);

	public GenerarConciliacion buscarPorIdConcTabla(Integer idConcTabla);
    
}
