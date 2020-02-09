package edu.taller.sisgea.mantenimientosgenerales.service.region;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IRegionMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Region;


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
