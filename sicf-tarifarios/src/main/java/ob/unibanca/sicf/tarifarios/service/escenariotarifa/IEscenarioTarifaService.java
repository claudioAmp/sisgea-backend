package ob.unibanca.sicf.tarifarios.service.escenariotarifa;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.EscenarioTarifa;

import java.util.List;

public interface IEscenarioTarifaService extends IMantenibleService<EscenarioTarifa> {

	List<EscenarioTarifa> buscarTodosEscenariosTarifas();

	EscenarioTarifa buscarEscenarioTarifa(int idEscenarioTarifa);

	EscenarioTarifa registrarEscenarioTarifa(EscenarioTarifa escenarioTarifa);

	EscenarioTarifa actualizarEscenarioTarifa(int idEscenarioTarifa, EscenarioTarifa escenarioTarifa);

    void eliminarEscenarioTarifa(int idEscenarioTarifa);
}
