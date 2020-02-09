package edu.taller.sisgea.tarifarios.mapper;

import edu.taller.sisgea.tarifarios.model.TarifarioAdquirente;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioAdquirenteMapper extends IMantenibleMapper<TarifarioAdquirente> {
	
	Optional<TarifarioAdquirente> buscarTarifarioAdquirente(int idTarifarioAdquirente);

}