package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.CampoActualizar;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoActualizarMapper extends IMantenibleMapper<CampoActualizar> {
	
	Optional<CampoActualizar> buscarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla);
	
	List<CampoActualizar> buscarCampoActualizarPorConciliacionTablas(Integer idConcTabla);
	
}
