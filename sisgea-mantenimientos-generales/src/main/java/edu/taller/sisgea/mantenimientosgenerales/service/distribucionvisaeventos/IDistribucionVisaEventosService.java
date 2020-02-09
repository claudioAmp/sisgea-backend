package edu.taller.sisgea.mantenimientosgenerales.service.distribucionvisaeventos;

import edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;

import java.util.List;

public interface IDistribucionVisaEventosService {
	
	List<DistribucionVisaEventos> buscarRegistrosDistribucionEventosVisa();

	DistribucionVisaEventos buscarRegistroDistribucionEventosVisa(String secuenciaAgrupada);

	DistribucionVisaEventos actualizarDistribucionVisaEventos(String secuenciaAgrupada, DistribucionVisaEventos distribucionVisaEventos);
	
}