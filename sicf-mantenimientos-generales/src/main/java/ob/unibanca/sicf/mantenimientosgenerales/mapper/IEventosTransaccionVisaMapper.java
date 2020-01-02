package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosTransaccionVisa;

@Mapper
public interface IEventosTransaccionVisaMapper extends IMantenibleMapper<EventosTransaccionVisa> {
	
	public List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisaSinTxn();
}
