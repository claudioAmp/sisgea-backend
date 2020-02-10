package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.DetalleHorario;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IDetalleHorarioMapper extends IMantenibleMapper<DetalleHorario> {

    Optional<DetalleHorario> buscarDetalleHorario(Integer idHorarioDetalle, String idCurso, Integer seccion, Integer idHorario);

}
