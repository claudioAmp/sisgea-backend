package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.CampoInsertarObservada;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoInsertarObservadaMapper extends IMantenibleMapper<CampoInsertarObservada> {
	
	Optional<CampoInsertarObservada> buscarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla);
	
	List<CampoInsertarObservada> buscarCampoInsertarObservadaPorConciliacionTablas(Integer idConcTabla);
	
}
