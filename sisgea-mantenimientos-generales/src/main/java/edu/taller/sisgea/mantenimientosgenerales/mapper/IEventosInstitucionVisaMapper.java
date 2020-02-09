package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.EventosInstitucionVisa;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface IEventosInstitucionVisaMapper extends IMantenibleMapper<EventosInstitucionVisa>{
	
	public List<EventosInstitucionVisa> buscarPorInst(@Param("idInstitucion") Integer idInstitucion);
}
