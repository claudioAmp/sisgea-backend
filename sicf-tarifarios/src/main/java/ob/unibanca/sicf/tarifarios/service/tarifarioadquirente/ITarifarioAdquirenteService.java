package ob.unibanca.sicf.tarifarios.service.tarifarioadquirente;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.TarifarioAdquirente;

import java.util.List;

public interface ITarifarioAdquirenteService extends IMantenibleService<TarifarioAdquirente> {

	List<TarifarioAdquirente> buscarTodosTarifariosAdquirentes();
    
	TarifarioAdquirente buscarTarifarioAdquirente(int idTarifarioAdquirente);

	TarifarioAdquirente registrarTarifarioAdquirente(TarifarioAdquirente tarifarioAdquirente);

	TarifarioAdquirente actualizarTarifarioAdquirente(int idTarifarioAdquirente, TarifarioAdquirente tarifarioAdquirente);

    void eliminarTarifarioAdquirente(int idTarifarioAdquirente);
    
}