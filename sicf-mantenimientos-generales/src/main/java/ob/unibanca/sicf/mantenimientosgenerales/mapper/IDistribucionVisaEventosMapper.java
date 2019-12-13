package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDistribucionVisaEventosMapper {
	
	List<DistribucionVisaEventos> buscarRegistrosDistribucionEventosVisa();
	
}
