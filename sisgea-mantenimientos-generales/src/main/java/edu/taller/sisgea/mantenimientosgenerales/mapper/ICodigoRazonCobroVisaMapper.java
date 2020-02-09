package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.CodigoRazonCobroVisa;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ICodigoRazonCobroVisaMapper extends IMantenibleMapper<CodigoRazonCobroVisa> {
    Optional<CodigoRazonCobroVisa> buscarCodigoRazonCobroVisa(String idCodigoRazonCobroVisa);
}
