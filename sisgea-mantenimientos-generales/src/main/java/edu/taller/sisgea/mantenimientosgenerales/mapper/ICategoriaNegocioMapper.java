package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.CategoriaNegocio;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ICategoriaNegocioMapper extends IMantenibleMapper<CategoriaNegocio>{
	List<CategoriaNegocio> buscarTodos();
}
