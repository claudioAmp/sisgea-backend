package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.CampoMatching;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoMatchingMapper extends IMantenibleMapper<CampoMatching> {
	
	Optional<CampoMatching> buscarCampoMatching(Integer idCampoMatching, Integer idConcTabla);
	
	List<CampoMatching> buscarCampoMatchingPorConciliacionTablas(Integer idConcTabla);
	
}
