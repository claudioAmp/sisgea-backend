package edu.taller.sisgea.tarifarios.service.tarifarioemisor;

import edu.taller.sisgea.tarifarios.model.TarifarioEmisor;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ITarifarioEmisorService extends IMantenibleService<TarifarioEmisor> {

	List<TarifarioEmisor> buscarTodosTarifariosEmisores();
    
	TarifarioEmisor buscarTarifarioEmisor(int idTarifarioEmisor);

	TarifarioEmisor registrarTarifarioEmisor(TarifarioEmisor tarifarioEmisor);

	TarifarioEmisor actualizarTarifarioEmisor(int idTarifarioEmisor, TarifarioEmisor tarifarioEmisor);

    void eliminarTarifarioEmisor(int idTarifarioEmisor);
    
}