package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosInstitucionMastercard;

@Mapper
public interface IEventosInstitucionMastercardMapper extends IMantenibleMapper<EventosInstitucionMastercard>{
	
	public List<EventosInstitucionMastercard> buscarPorInst(@Param("idInstitucion") Integer idInstitucion);
}
