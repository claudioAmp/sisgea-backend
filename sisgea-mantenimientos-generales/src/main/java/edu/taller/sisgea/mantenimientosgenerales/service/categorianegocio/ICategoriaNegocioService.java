package edu.taller.sisgea.mantenimientosgenerales.service.categorianegocio;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.CategoriaNegocio;
import ob.commons.mantenimiento.service.IMantenibleService;


public interface ICategoriaNegocioService extends IMantenibleService<CategoriaNegocio> {
	List<CategoriaNegocio> buscarTodosCategoriasNegocios();
}
