package edu.taller.sisgea.tarifarios.mapper;

import edu.taller.sisgea.tarifarios.model.TipoTarifa;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITipoTarifaMapper extends IMantenibleMapper<TipoTarifa> {
	
	Optional<TipoTarifa> buscarTipoTarifa(int idTarifa);

}