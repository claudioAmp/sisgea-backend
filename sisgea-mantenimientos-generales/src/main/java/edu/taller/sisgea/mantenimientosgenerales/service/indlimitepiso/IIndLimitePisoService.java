package edu.taller.sisgea.mantenimientosgenerales.service.indlimitepiso;

import java.util.List;
import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.IndLimitePiso;

public interface IIndLimitePisoService extends IMantenibleService<IndLimitePiso>{
	
	List<IndLimitePiso> buscarTodosIndLimitePiso();
}
