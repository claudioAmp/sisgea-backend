package ob.unibanca.sicf.mantenimientosgenerales.service.servicio;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IServicioMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Servicio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServicioService extends MantenibleService<Servicio> implements IServicioService {
	
	private final IServicioMapper servicioMapper;
	
	public ServicioService(@Qualifier("IServicioMapper") IMantenibleMapper<Servicio> mantenibleMapper) {
		super(mantenibleMapper);
		this.servicioMapper = (IServicioMapper) mantenibleMapper;
	}
}
