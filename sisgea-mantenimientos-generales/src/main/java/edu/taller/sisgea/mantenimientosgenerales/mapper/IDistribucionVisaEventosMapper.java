package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;
import edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventosDetalle;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import java.util.Optional;

@Mapper
public interface IDistribucionVisaEventosMapper {
	
	List<DistribucionVisaEventos> buscarRegistrosDistribucionEventosVisa();

	Optional<DistribucionVisaEventos> buscarRegistroDistribucionEventosVisa(String secuenciaAgrupada);

	void actualizarDistribucionVisaEventos(DistribucionVisaEventosDetalle distribucionVisaEventos);
	
}
