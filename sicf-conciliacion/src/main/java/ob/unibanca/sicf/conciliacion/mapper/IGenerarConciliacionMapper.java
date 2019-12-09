package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.GenerarConciliacion;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IGenerarConciliacionMapper extends IMantenibleMapper<GenerarConciliacion> {
	
	List<GenerarConciliacion> buscarCamposTablaObservada();
	
	GenerarConciliacion buscarPorIdConcTabla(Integer idConcTabla);
	
}
