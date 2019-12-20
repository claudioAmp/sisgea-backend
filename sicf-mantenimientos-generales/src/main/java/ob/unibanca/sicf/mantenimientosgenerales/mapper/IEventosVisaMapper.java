package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosVisa;

@Mapper
public interface IEventosVisaMapper extends IMantenibleMapper<EventosVisa> {

    public List<EventosVisa> buscaridDescripcion();

}
