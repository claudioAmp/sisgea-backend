package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.CampoDiferencia;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoDiferenciaMapper extends IMantenibleMapper<CampoDiferencia> {
	
	Optional<CampoDiferencia> buscarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla);
	
	List<CampoDiferencia> buscarCampoDiferenciaPorConciliacionTablas(Integer idConcTabla);
	
}
