package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.IndLimitePiso;

@Mapper
public interface IIndLimitePisoMapper extends IMantenibleMapper<IndLimitePiso>{
	List<IndLimitePiso> buscarTodos();
}
