package ob.unibanca.sicf.reportes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.reportes.model.Campo;

@Mapper
public interface ICampoMapper extends IMantenibleMapper<Campo>{
	List<Campo> buscarTodos();
}
