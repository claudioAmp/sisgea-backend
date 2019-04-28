package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionfondo;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionFondo;

public interface IDistribucionFondoService extends IMantenibleService<DistribucionFondo>{

	List<DistribucionFondo> buscarTodosDistFondo();
	
	DistribucionFondo buscarDistribucionFondo(int idDistribucionFondo);

	DistribucionFondo registrarDistribucionComision(DistribucionFondo distribucionFondo);

	DistribucionFondo actualizarDistribucionFondo(int idDistribucionFondo, DistribucionFondo distribucionFondo);

	void eliminarDistribucionFondo(int idDistribucionFondo);

}
