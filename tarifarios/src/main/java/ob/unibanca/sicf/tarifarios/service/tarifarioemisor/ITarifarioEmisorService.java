package ob.unibanca.sicf.tarifarios.service.tarifarioemisor;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.TarifarioEmisor;

import java.util.List;

public interface ITarifarioEmisorService extends IMantenibleService<TarifarioEmisor> {

	List<TarifarioEmisor> buscarTodosTarifariosEmisores();
    
	TarifarioEmisor buscarTarifarioEmisor(int idTarifarioEmisor);

	TarifarioEmisor registrarTarifarioEmisor(TarifarioEmisor tarifarioEmisor);

	TarifarioEmisor actualizarTarifarioEmisor(int idTarifarioEmisor, TarifarioEmisor tarifarioEmisor);

    void eliminarTarifarioEmisor(int idTarifarioEmisor);
    
}