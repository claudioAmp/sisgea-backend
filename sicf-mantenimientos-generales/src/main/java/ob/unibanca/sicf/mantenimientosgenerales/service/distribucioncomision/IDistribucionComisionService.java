package ob.unibanca.sicf.mantenimientosgenerales.service.distribucioncomision;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionComision;

public interface IDistribucionComisionService extends IMantenibleService<DistribucionComision>{
	
	List<DistribucionComision> buscarTodosDistComision();
	
	DistribucionComision buscarDistribucionComision(int idDistribucionComision);

	DistribucionComision registrarDistribucionComision(DistribucionComision distribucionComision);

	DistribucionComision actualizarDistribucionComision(int idDistribucionComision, DistribucionComision distribucionComision);

	void eliminarDistribucionComision(int idDistribucionComision);

}
