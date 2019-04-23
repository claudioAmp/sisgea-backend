package ob.unibanca.sicf.reportes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.unibanca.sicf.reportes.model.Tabla;

@Mapper
public interface ITablaMapper {
	List<Tabla> buscarTodos();
}
