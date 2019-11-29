package ob.unibanca.sicf.consultasgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITipoCambioSBSMapper extends IMantenibleMapper<TipoCambioSBS> {
	
}
