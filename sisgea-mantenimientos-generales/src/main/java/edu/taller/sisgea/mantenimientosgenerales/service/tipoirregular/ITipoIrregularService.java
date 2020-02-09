package edu.taller.sisgea.mantenimientosgenerales.service.tipoirregular;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.TipoIrregular;

public interface ITipoIrregularService 	extends IMantenibleService<TipoIrregular>{
		
		List<TipoIrregular> buscarTodosTiposIrregular();
}
