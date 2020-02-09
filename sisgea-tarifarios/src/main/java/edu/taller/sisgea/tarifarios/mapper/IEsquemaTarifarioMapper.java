package edu.taller.sisgea.tarifarios.mapper;

import java.util.Optional;

import edu.taller.sisgea.tarifarios.model.EsquemaTarifario;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface IEsquemaTarifarioMapper extends IMantenibleMapper<EsquemaTarifario>{
	
	Optional<EsquemaTarifario> buscarEsquemaTarifario(int idEsquema);
}
