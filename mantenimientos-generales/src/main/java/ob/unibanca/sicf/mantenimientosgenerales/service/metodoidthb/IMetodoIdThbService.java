package ob.unibanca.sicf.mantenimientosgenerales.service.metodoidthb;

import java.util.List;
import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.MetodoIdThb;

public interface IMetodoIdThbService extends IMantenibleService<MetodoIdThb> {
        
    List<MetodoIdThb> buscarTodosMetodoIdThb();
	
	List<MetodoIdThb> buscarMetodoIdThbPorMembresia(String idMembresia);
	
	MetodoIdThb buscarMetodoIdThb(String idMembresia, String idmetodoIdThb);
	
	MetodoIdThb registrarMetodoIdThb(String idMembresia, MetodoIdThb metodoIdThb);
	
	MetodoIdThb actualizarMetodoIdThb(String idMembresia, String idMetodoIdThb, MetodoIdThb metodoIdThb);
	
	void eliminarMetodoIdThb(String idMembresia, String idmetodoIdThb);
}
