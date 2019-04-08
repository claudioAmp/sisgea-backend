package ob.unibanca.sicf.mantenimientosgenerales.service.transaccionmarcaint;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.TransaccionMarcaInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaccionMarcaIntService extends MantenibleService<TransaccionMarcaInt> implements ITransaccionMarcaIntService {
	
	public TransaccionMarcaIntService(@Qualifier("ITransaccionMarcaIntMapper") IMantenibleMapper<TransaccionMarcaInt> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TransaccionMarcaInt> buscarTodasTransaccionesMarcaInt() {
		return super.buscarTodos();
   }
   
}
