package edu.taller.sisgea.mantenimientosgenerales.service.moneda;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Moneda;

import java.util.List;

public interface IMonedaService extends IMantenibleService<Moneda> {
	
	List<Moneda> buscarTodosMonedas();
}
