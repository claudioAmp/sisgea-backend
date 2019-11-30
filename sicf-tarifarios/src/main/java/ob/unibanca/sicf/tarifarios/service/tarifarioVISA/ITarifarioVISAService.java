package ob.unibanca.sicf.tarifarios.service.tarifarioVISA;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.TarifarioVISA;

import java.util.List;

public interface ITarifarioVISAService extends IMantenibleService<TarifarioVISA> {

    List<TarifarioVISA> buscarTodosTarifariosVISA();

    TarifarioVISA buscarTarifarioVISA(int tarifarioVISA);

    TarifarioVISA registrarTarifarioVISA(TarifarioVISA tarifarioVISA);

    TarifarioVISA actualizarTarifarioVISA(int idTarifarioVISA, TarifarioVISA tarifarioVISA);

    void eliminarTarifarioVISA(int idTarifarioVISA);
}
