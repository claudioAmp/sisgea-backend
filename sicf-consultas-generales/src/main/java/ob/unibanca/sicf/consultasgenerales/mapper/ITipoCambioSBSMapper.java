package ob.unibanca.sicf.consultasgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITipoCambioSBSMapper extends IMantenibleMapper<TipoCambioSBS> {
	
	public List<TipoCambioSBS> buscarIdTipoCambio(TipoCambioSBS tipoCambioSBS);
}
