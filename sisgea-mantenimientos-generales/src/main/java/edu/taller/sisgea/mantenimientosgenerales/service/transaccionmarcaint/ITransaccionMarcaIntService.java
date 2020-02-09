package edu.taller.sisgea.mantenimientosgenerales.service.transaccionmarcaint;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.TransaccionMarcaInt;

import java.util.List;

public interface ITransaccionMarcaIntService extends IMantenibleService<TransaccionMarcaInt> {
	
	List<TransaccionMarcaInt> buscarTodasTransaccionesMarcaInt();
	
}
