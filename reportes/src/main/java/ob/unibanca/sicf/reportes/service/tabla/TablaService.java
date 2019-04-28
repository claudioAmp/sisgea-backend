package ob.unibanca.sicf.reportes.service.tabla;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.reportes.model.Tabla;

@Service
public class TablaService extends MantenibleService<Tabla> implements ITablaService {
	
	public TablaService(@Qualifier("ITablaMapper") IMantenibleMapper<Tabla> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Tabla> buscarTodosTablas() {
		return this.buscarTodos();
	}
	
}
