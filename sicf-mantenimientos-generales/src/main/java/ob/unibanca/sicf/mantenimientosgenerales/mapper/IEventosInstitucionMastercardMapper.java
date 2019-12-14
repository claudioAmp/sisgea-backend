package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosInstitucionMastercard;

@Mapper
public interface IEventosInstitucionMastercardMapper extends IMantenibleMapper<EventosInstitucionMastercard>{
	
	public List<EventosInstitucionMastercard> buscarPorInst(@Param("idInstitucion") Integer idInstitucion);
}
