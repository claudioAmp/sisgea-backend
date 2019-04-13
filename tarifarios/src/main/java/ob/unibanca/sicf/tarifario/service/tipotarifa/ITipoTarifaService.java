package ob.unibanca.sicf.tarifario.service.tipotarifa;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifario.model.TipoTarifa;

import java.util.List;

public interface ITipoTarifaService extends IMantenibleService<TipoTarifa> {

	List<TipoTarifa> buscarTodosTipoTarifa();
    
	TipoTarifa buscarTipoTarifa(int idTarifa);

	TipoTarifa registrarTipoTarifa(TipoTarifa tipoTarifa);

	TipoTarifa actualizarTipoTarifa(int idTarifa, TipoTarifa tipoTarifa);

    void eliminarTipoTarifa(int idTarifa);
}
