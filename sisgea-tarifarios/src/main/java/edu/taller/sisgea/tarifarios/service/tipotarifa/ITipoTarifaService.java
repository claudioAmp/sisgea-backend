package edu.taller.sisgea.tarifarios.service.tipotarifa;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.tarifarios.model.TipoTarifa;

import java.util.List;

public interface ITipoTarifaService extends IMantenibleService<TipoTarifa> {

	List<TipoTarifa> buscarTodosTiposTarifas();
    
	TipoTarifa buscarTipoTarifa(int idTarifa);

	TipoTarifa registrarTipoTarifa(TipoTarifa tipoTarifa);

	TipoTarifa actualizarTipoTarifa(int idTarifa, TipoTarifa tipoTarifa);

    void eliminarTipoTarifa(int idTarifa);
    
}