package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisaeventos;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IDistribucionVisaEventosMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistribucionVisaEventosService implements IDistribucionVisaEventosService {
	
	private final IDistribucionVisaEventosMapper distribucionMapper;
	
	public DistribucionVisaEventosService(@Qualifier("IDistribucionVisaEventosMapper") IDistribucionVisaEventosMapper mantenibleMapper) {
		this.distribucionMapper = (IDistribucionVisaEventosMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<DistribucionVisaEventos> buscarRegistrosDistribucionEventosVisa() {
		return this.distribucionMapper.buscarRegistrosDistribucionEventosVisa();
	}
	
}
