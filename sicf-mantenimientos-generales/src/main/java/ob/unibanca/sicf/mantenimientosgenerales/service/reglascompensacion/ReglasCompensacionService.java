package ob.unibanca.sicf.mantenimientosgenerales.service.reglascompensacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IReglasCompensacionMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ReglasCompensacion;

@Service
public class ReglasCompensacionService extends MantenibleService<ReglasCompensacion> implements IReglasCompensacionService {
	
	private static final String REGLA_COMPENSACION_NO_ENCONTRADO = "La regla de compensación %s no existe";
	private final IReglasCompensacionMapper reglasCompensacionMapper;
	
	public ReglasCompensacionService(@Qualifier("IReglasCompensacionMapper") IMantenibleMapper<ReglasCompensacion> mantenibleMapper) {
		super(mantenibleMapper);
		this.reglasCompensacionMapper = (IReglasCompensacionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ReglasCompensacion> buscarTodos(){
		return this.reglasCompensacionMapper.buscarTodos();
	}
	
}
