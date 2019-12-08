package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.TipoComision;

@Mapper
public interface ITipoComisionMapper extends IMantenibleMapper<TipoComision> {
	
	List<TipoComision> buscarTodos();
	
	TipoComision buscarUno(Integer idTipoComision);
}