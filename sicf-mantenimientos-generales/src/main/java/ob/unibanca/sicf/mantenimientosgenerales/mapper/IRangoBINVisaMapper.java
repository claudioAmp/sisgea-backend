package ob.unibanca.sicf.mantenimientosgenerales.mapper;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.RangoBINVisa;

@Mapper
public interface IRangoBINVisaMapper extends IMantenibleMapper<RangoBINVisa> {
	
}