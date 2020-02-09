package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.TipoComision;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface ITipoComisionMapper extends IMantenibleMapper<TipoComision> {
	
	List<TipoComision> buscarTodos();
	
	TipoComision buscarUno(Integer idTipoComision);
}