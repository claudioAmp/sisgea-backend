package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.CampoInsertarObservada;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoInsertarObservadaMapper extends IMantenibleMapper<CampoInsertarObservada> {
	
	Optional<CampoInsertarObservada> buscarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla);
	
	List<CampoInsertarObservada> buscarCampoInsertarObservadaPorConciliacionTablas(Integer idConcTabla);
	
}
