package ob.unibanca.sicf.tarifarios.service.tarifariomiembro;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.TarifarioMiembro;

import java.util.List;

public interface ITarifarioMiembroService extends IMantenibleService<TarifarioMiembro> {
	
	List<TarifarioMiembro> buscarTodosTarifariosMiembros();

    TarifarioMiembro buscarTarifarioMiembro(Integer idTarifarioMiembro);
	
	TarifarioMiembro registrarTarifarioMiembro(TarifarioMiembro tarifarioMiembro);
	
	TarifarioMiembro actualizarTarifarioMiembro(Integer idTarifarioMiembro, TarifarioMiembro tarifarioMiembro);
	
	void eliminarTarifarioMiembro(Integer idTarifarioMiembro);

}
