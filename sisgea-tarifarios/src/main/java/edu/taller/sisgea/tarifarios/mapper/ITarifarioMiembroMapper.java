package edu.taller.sisgea.tarifarios.mapper;

import edu.taller.sisgea.tarifarios.model.TarifarioMiembro;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioMiembroMapper extends IMantenibleMapper<TarifarioMiembro> {
	
	Optional<TarifarioMiembro> buscarTarifarioMiembro(Integer idTarifarioMiembro);
}