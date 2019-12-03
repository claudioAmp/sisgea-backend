package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.TasaInteresPasiva;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Mapper
public interface ITasaInteresPasivaMapper extends IMantenibleMapper<TasaInteresPasiva> {
    Optional<TasaInteresPasiva> buscarTasaInteresPasiva(Date fechaProceso);
    List<TasaInteresPasiva> buscarTodos();
}