package ob.unibanca.sicf.mantenimientosgenerales.service.transaccionmarcaint;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.TransaccionMarcaInt;

import java.util.List;

public interface ITransaccionMarcaIntService extends IMantenibleService<TransaccionMarcaInt> {
	
	List<TransaccionMarcaInt> buscarTodasTransaccionesMarcaInt();
	
}
