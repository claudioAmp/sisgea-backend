package edu.taller.sisgea.mantenimientosgenerales.service.distribucionfondo;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.DistribucionFondo;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface IDistribucionFondoService extends IMantenibleService<DistribucionFondo>{

	List<DistribucionFondo> buscarTodosDistFondo();
	
	DistribucionFondo buscarDistribucionFondo(int idDistribucionFondo);

	DistribucionFondo registrarDistribucionFondo(DistribucionFondo distribucionFondo);

	DistribucionFondo actualizarDistribucionFondo(int idDistribucionFondo, DistribucionFondo distribucionFondo);

	void eliminarDistribucionFondo(int idDistribucionFondo);

}
