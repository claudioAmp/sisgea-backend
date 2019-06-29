package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionFondo;
import ob.unibanca.sicf.mantenimientosgenerales.model.GiroNegocio;

@Mapper
public interface IGiroNegocioMapper extends IMantenibleMapper<GiroNegocio>{
	
	List<GiroNegocio> buscarTodosGiroNegocio();
	
	List<GiroNegocio> buscarGiroNegocioPorMembresia(String idMembresia);
}
