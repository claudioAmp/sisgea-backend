package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.IndLimitePiso;

@Mapper
public interface IIndLimitePisoMapper extends IMantenibleMapper<IndLimitePiso>{
	List<IndLimitePiso> buscarTodos();
}
