package edu.taller.sisgea.mantenimientosgenerales.service.moneda;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Moneda;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MonedaService extends MantenibleService<Moneda> implements IMonedaService {
	
	public MonedaService(@Qualifier("IMonedaMapper") IMantenibleMapper<Moneda> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Moneda> buscarTodosMonedas() {
		return super.buscarTodos();
	}
}
