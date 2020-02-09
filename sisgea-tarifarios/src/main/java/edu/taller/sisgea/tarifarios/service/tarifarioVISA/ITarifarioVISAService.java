package edu.taller.sisgea.tarifarios.service.tarifarioVISA;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.tarifarios.model.TarifarioVISA;

import java.util.List;

public interface ITarifarioVISAService extends IMantenibleService<TarifarioVISA> {

    List<TarifarioVISA> buscarTodosTarifariosVISA();

    TarifarioVISA buscarTarifarioVISA(String idTarifarioVisa, Integer idTipoComision);

    TarifarioVISA registrarTarifarioVISA(TarifarioVISA tarifarioVisa);

    TarifarioVISA actualizarTarifarioVISA(String idTarifarioVisa, TarifarioVISA tarifarioVisa);

    void eliminarTarifarioVISA(TarifarioVISA tarifarioVisa);
}
