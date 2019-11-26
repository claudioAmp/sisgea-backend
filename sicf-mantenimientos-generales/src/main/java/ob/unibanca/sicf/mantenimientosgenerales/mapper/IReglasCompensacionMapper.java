package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ReglasCompensacion;

@Mapper
public interface IReglasCompensacionMapper extends IMantenibleMapper<ReglasCompensacion>  {
	List<ReglasCompensacion> buscarTodos();
}
