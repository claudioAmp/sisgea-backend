package ob.unibanca.sicf.mantenimientosgenerales.service.tipoirregular;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.TipoIrregular;

public interface ITipoIrregularService 	extends IMantenibleService<TipoIrregular>{
		
		List<TipoIrregular> buscarTodosTiposIrregular();
}
