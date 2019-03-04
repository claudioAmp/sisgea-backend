package ob.unibanca.sicf.mantenimientosgenerales.service.atmredasociada;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedAsociada;

import java.util.List;

public interface IATMRedAsociadaService extends IMantenibleService<ATMRedAsociada> {

    List<ATMRedAsociada> buscarTodosATMsRedAsociada();

    ATMRedAsociada buscarATMRedAsociada(int idATM, int idInstitucion);

    List<ATMRedAsociada> buscarATMsRedAsociadaInstitucion(int idInstitucion);

    ATMRedAsociada registrarATMRedAsociada(int idInstitucion, ATMRedAsociada atmRedAsociada);

    ATMRedAsociada actualizarATMRedAsociada(int idATM, int idInstitucion, ATMRedAsociada atmRedAsociada);

    void eliminarATMRedAsociada(int idATM, int idInstitucion);
    
}
