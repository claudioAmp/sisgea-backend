package ob.unibanca.sicf.mantenimientosgenerales.service.atmredunicard;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedUnicard;

import java.util.List;

public interface IATMRedUnicardService extends IMantenibleService<ATMRedUnicard> {

    List<ATMRedUnicard> buscarTodosATMsRedUnicard();

    ATMRedUnicard registrarATMRedUnicard(ATMRedUnicard atmRedUnicard);

    ATMRedUnicard actualizarATMRedUnicard(int idATM, ATMRedUnicard atmRedUnicard);

    void eliminarATMRedUnicard(int idATM);

}
