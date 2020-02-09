package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Perfil;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface IPerfilMapper extends IMantenibleMapper<Perfil>{
	List<Perfil> buscarTodos();
}
