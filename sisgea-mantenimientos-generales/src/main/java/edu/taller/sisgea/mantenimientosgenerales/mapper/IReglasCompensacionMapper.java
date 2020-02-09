package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.ReglasCompensacion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface IReglasCompensacionMapper extends IMantenibleMapper<ReglasCompensacion>  {
	
	List<ReglasCompensacion> buscarTodosReglasCompensacion();
	
	List<ReglasCompensacion> buscarPorIdReglasCompensacion(@Param("idReglasCompensacion") Integer idReglasCompensacion);
}
