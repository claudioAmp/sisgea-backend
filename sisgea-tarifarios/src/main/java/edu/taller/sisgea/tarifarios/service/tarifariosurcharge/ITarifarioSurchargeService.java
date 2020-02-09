package edu.taller.sisgea.tarifarios.service.tarifariosurcharge;

import edu.taller.sisgea.tarifarios.model.TarifarioSurcharge;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ITarifarioSurchargeService extends IMantenibleService<TarifarioSurcharge> {

	List<TarifarioSurcharge> buscarTodosTarifariosSurcharges();
    
	TarifarioSurcharge buscarTarifarioSurcharge(int idTarifarioSurcharge);

	TarifarioSurcharge registrarTarifarioSurcharge(TarifarioSurcharge tarifarioSurcharge);

	TarifarioSurcharge actualizarTarifarioSurcharge(int idTarifarioSurcharge, TarifarioSurcharge tarifarioSurcharge);

    void eliminarTarifarioSurcharge(int idTarifarioSurcharge);
    
}