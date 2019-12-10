package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.CampoMatching;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoMatchingMapper extends IMantenibleMapper<CampoMatching> {
	
	Optional<CampoMatching> buscarCampoMatching(Integer idCampoMatching, Integer idConcTabla);
	
	List<CampoMatching> buscarCampoMatchingPorConciliacionTablas(Integer idConcTabla);
	
}
