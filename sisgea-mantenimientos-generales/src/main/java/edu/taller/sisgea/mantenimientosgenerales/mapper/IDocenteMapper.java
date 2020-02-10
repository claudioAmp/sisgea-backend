package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.Docente;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDocenteMapper extends IMantenibleMapper<Docente> {

    List<Docente> buscarTodos();

}
