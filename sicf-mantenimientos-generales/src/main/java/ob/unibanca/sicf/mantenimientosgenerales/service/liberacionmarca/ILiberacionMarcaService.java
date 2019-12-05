package ob.unibanca.sicf.mantenimientosgenerales.service.liberacionmarca;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.LiberacionMarca;

import java.util.List;

public interface ILiberacionMarcaService extends IMantenibleService<LiberacionMarca> {
	
	List<LiberacionMarca> buscarTodosLiberacionMarcas();
	
	List<LiberacionMarca> buscarLiberacionMarcasPorMembresia(String idMembresia);
	
	LiberacionMarca buscarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso);
	
	LiberacionMarca registrarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso, LiberacionMarca servicio);
	
	LiberacionMarca actualizarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso, LiberacionMarca liberacionMarca);
	
	void eliminarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso);
}