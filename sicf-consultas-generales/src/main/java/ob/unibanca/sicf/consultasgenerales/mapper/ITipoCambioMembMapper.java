package ob.unibanca.sicf.consultasgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITipoCambioMembMapper extends IMantenibleMapper<TipoCambioMemb> {
	
	public List<TipoCambioMemb> buscarPorIdTipoCambio(TipoCambioMemb tipoCambioMemb);

}
