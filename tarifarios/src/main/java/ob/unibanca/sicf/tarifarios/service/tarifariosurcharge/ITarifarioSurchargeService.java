package ob.unibanca.sicf.tarifarios.service.tarifariosurcharge;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.TarifarioSurcharge;

import java.util.List;

public interface ITarifarioSurchargeService extends IMantenibleService<TarifarioSurcharge> {

	List<TarifarioSurcharge> buscarTodosTarifariosSurcharges();
    
	TarifarioSurcharge buscarTarifarioSurcharge(int idTarifarioSurcharge);

	TarifarioSurcharge registrarTarifarioSurcharge(TarifarioSurcharge tarifarioSurcharge);

	TarifarioSurcharge actualizarTarifarioSurcharge(int idTarifarioSurcharge, TarifarioSurcharge tarifarioSurcharge);

    void eliminarTarifarioSurcharge(int idTarifarioSurcharge);
    
}