package ob.unibanca.sicf.reportes.mapper;

import java.util.List;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.reportes.model.Operador;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOperadorMapper extends IMantenibleMapper<Operador> {
	List<Operador> buscarOperadorPorTipoDato(String tipoDato);
}

