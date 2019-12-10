package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosInstitucionVisa;

@Mapper
public interface IEventosInstitucionVisaMapper extends IMantenibleMapper<EventosInstitucionVisa>{
	
	public List<EventosInstitucionVisa> buscarPorInst(@Param("idInstitucion") Integer idInstitucion);
}
