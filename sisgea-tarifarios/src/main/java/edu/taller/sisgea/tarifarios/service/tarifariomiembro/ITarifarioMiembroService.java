package edu.taller.sisgea.tarifarios.service.tarifariomiembro;

import edu.taller.sisgea.tarifarios.model.TarifarioMiembro;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ITarifarioMiembroService extends IMantenibleService<TarifarioMiembro> {
	
	List<TarifarioMiembro> buscarTodosTarifariosMiembros();

    TarifarioMiembro buscarTarifarioMiembro(Integer idTarifarioMiembro);
	
	TarifarioMiembro registrarTarifarioMiembro(TarifarioMiembro tarifarioMiembro);
	
	TarifarioMiembro actualizarTarifarioMiembro(Integer idTarifarioMiembro, TarifarioMiembro tarifarioMiembro);
	
	void eliminarTarifarioMiembro(Integer idTarifarioMiembro);

}
