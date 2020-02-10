package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.Horario;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IHorarioMapper extends IMantenibleMapper<Horario> {

    Optional<Horario> buscarHorario (Integer idHorario, String idCurso, Integer seccion);

}
