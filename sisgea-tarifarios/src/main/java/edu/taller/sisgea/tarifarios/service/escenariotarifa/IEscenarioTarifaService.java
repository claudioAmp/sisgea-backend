package edu.taller.sisgea.tarifarios.service.escenariotarifa;

import edu.taller.sisgea.tarifarios.model.EscenarioTarifa;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IEscenarioTarifaService extends IMantenibleService<EscenarioTarifa> {

	List<EscenarioTarifa> buscarTodosEscenariosTarifas();

	EscenarioTarifa buscarEscenarioTarifa(int idEscenarioTarifa);

	EscenarioTarifa registrarEscenarioTarifa(EscenarioTarifa escenarioTarifa);

	EscenarioTarifa actualizarEscenarioTarifa(int idEscenarioTarifa, EscenarioTarifa escenarioTarifa);

    void eliminarEscenarioTarifa(int idEscenarioTarifa);
}
