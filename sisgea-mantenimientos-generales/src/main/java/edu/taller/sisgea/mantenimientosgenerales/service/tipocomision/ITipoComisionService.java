package edu.taller.sisgea.mantenimientosgenerales.service.tipocomision;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.TipoComision;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface ITipoComisionService extends IMantenibleService<TipoComision> {
	
	List<TipoComision> buscarTodosTiposComision();
	
	TipoComision  buscarPorIdTipoComision(Integer idTipoComision);
}
