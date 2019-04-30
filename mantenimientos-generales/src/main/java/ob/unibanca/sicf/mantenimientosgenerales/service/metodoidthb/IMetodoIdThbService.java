/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob.unibanca.sicf.mantenimientosgenerales.service.metodoidthb;

import java.util.List;
import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.MetodoIdThb;

/**
 *
 * @author Asus
 */
public interface IMetodoIdThbService extends IMantenibleService<MetodoIdThb> {
        
        List<MetodoIdThb> buscarTodosMetodoIdThb();
	
	List<MetodoIdThb> buscarMetodoIdThbPorMembresia(String idMembresia);
	
	MetodoIdThb buscarMetodoIdThb(String idMembresia, String idmetodoIdThb);
	
	MetodoIdThb registrarMetodoIdThb(String idMembresia, MetodoIdThb metodoIdThb);
	
	MetodoIdThb actualizarMetodoIdThb(String idMembresia, String idMetodoIdThb, MetodoIdThb metodoIdThb);
	
	void eliminarMetodoIdThb(String idMembresia, String idmetodoIdThb);
}
