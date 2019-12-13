package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisaeventos;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;

import java.util.List;

public interface IDistribucionVisaEventosService {
	
	List<DistribucionVisaEventos> buscarRegistrosDistribucionEventosVisa();
	
}