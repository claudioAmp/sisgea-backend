package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventosDetalle;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import java.util.Optional;

@Mapper
public interface IDistribucionVisaEventosMapper {
	
	List<DistribucionVisaEventos> buscarRegistrosDistribucionEventosVisa();

	Optional<DistribucionVisaEventos> buscarRegistroDistribucionEventosVisa(String secuenciaAgrupada);

	void actualizarDistribucionVisaEventos(DistribucionVisaEventosDetalle distribucionVisaEventos);
	
}
