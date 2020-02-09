package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Usuario;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface IUsuarioMapper extends IMantenibleMapper<Usuario>{
	List<Usuario> buscarTodos();
}
