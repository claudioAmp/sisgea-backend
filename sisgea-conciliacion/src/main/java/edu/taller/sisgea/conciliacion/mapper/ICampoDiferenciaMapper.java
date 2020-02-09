package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.CampoDiferencia;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICampoDiferenciaMapper extends IMantenibleMapper<CampoDiferencia> {
	
	Optional<CampoDiferencia> buscarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla);
	
	List<CampoDiferencia> buscarCampoDiferenciaPorConciliacionTablas(Integer idConcTabla);
	
}
