package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.unibanca.sicf.mantenimientosgenerales.mapper.base.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IInstitucionMapper extends IMantenibleMapper<Institucion> {

}
