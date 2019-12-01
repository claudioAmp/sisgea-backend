package ob.unibanca.sicf.tarifarios.service.tarifarioVISA;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.TarifarioVISA;

import java.util.List;

public interface ITarifarioVISAService extends IMantenibleService<TarifarioVISA> {

    List<TarifarioVISA> buscarTodosTarifariosVISA();

    TarifarioVISA buscarTarifarioVISA(String tarifarioVisa);

    TarifarioVISA registrarTarifarioVISA(TarifarioVISA tarifarioVisa);

    TarifarioVISA actualizarTarifarioVISA(String idTarifarioVisa, TarifarioVISA tarifarioVisa);

    void eliminarTarifarioVISA(String idTarifarioVisa);
}
