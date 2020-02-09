package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.GiroNegocio;

@Mapper
public interface IGiroNegocioMapper extends IMantenibleMapper<GiroNegocio>{
	
	List<GiroNegocio> buscarTodosGiroNegocio();
	
	List<GiroNegocio> buscarGiroNegocioPorMembresia(String idMembresia);
}
