package ob.unibanca.sicf.mantenimientosgenerales.service.servicio;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Servicio;

import java.util.List;

public interface IServicioService extends IMantenibleService<Servicio> {
	
	List<Servicio> buscarTodosServicios();
	
	List<Servicio> buscarServiciosMembresia(String idMembresia);
	
	Servicio buscarServicio(String idMembresia, String idServicio);
	
	Servicio registrarServicio(String idMembresia, Servicio servicio);
	
	Servicio actualizarServicio(String idMembresia, String idServicio, Servicio bin);
	
	void eliminarServicio(String idMembresia, String idServicio);
	
}