package edu.taller.sisgea.mantenimientosgenerales.service.atmredasociada;

import edu.taller.sisgea.mantenimientosgenerales.model.ATMRedAsociada;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IATMRedAsociadaService extends IMantenibleService<ATMRedAsociada> {

    List<ATMRedAsociada> buscarTodosATMsRedAsociada();

    ATMRedAsociada buscarATMRedAsociada(int idATM, int idInstitucion);

    List<ATMRedAsociada> buscarATMsRedAsociadaPorInstitucion(int idInstitucion);

    ATMRedAsociada registrarATMRedAsociada(int idInstitucion, ATMRedAsociada atmRedAsociada);

    ATMRedAsociada actualizarATMRedAsociada(int idATM, int idInstitucion, ATMRedAsociada atmRedAsociada);

    void eliminarATMRedAsociada(int idATM, int idInstitucion);
}
