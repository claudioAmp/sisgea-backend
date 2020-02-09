package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.CampoActualizar;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoActualizarMapper extends IMantenibleMapper<CampoActualizar> {
	
	Optional<CampoActualizar> buscarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla);
	
	List<CampoActualizar> buscarCampoActualizarPorConciliacionTablas(Integer idConcTabla);
	
}
