package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.Campo;


@Mapper
public interface ICampoMapper extends IMantenibleMapper<Campo>{
	List<Campo> buscarTodos();
}
