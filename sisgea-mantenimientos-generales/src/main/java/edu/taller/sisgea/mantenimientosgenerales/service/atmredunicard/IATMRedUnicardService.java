package edu.taller.sisgea.mantenimientosgenerales.service.atmredunicard;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.ATMRedUnicard;

import java.util.List;

public interface IATMRedUnicardService extends IMantenibleService<ATMRedUnicard> {

    List<ATMRedUnicard> buscarTodosATMsRedUnicard();
    
    ATMRedUnicard buscarATMRedUnicard(int idATM);

    ATMRedUnicard registrarATMRedUnicard(ATMRedUnicard atmRedUnicard);

    ATMRedUnicard actualizarATMRedUnicard(int idATM, ATMRedUnicard atmRedUnicard);

    void eliminarATMRedUnicard(int idATM);

}
