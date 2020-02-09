package edu.taller.sisgea.tarifarios.mapper;

import edu.taller.sisgea.tarifarios.model.TarifarioVISA;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioVISAMapper extends IMantenibleMapper<TarifarioVISA> {

    Optional<TarifarioVISA> buscarTarifarioVISA (String idTarifarioVisa, Integer idTipoComision);
}
