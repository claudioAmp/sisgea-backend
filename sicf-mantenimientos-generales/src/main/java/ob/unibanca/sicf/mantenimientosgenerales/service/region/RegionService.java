package ob.unibanca.sicf.mantenimientosgenerales.service.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IRegionMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Region;


@Service
public class RegionService  extends MantenibleService<Region> implements IRegionService {

	private final IRegionMapper regionMapper;
	
	public RegionService(@Qualifier("IRegionMapper") IMantenibleMapper<Region> mantenibleMapper) {
		super(mantenibleMapper);
		this.regionMapper = (IRegionMapper) mantenibleMapper;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Region> buscarTodosRegiones(){
		
		return this.buscarTodos();
	}
	
	
}
