package ob.unibanca.sicf.mantenimientosgenerales.mapper;


import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.TransaccionMarcaInt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransaccionMarcaIntMapper extends IMantenibleMapper<TransaccionMarcaInt> {

}
