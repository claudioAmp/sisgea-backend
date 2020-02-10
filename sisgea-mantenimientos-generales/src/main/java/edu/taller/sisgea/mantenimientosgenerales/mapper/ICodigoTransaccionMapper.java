package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.CodigoTransaccion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICodigoTransaccionMapper extends IMantenibleMapper<CodigoTransaccion> {

    Optional<CodigoTransaccion> buscarCodigoTransaccion(int idClaseTransaccion, int idCodigoTransaccion);

    List<CodigoTransaccion> buscarCodigosTransaccionPorClaseTransaccion(int idClaseTransaccion);
}