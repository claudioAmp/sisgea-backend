package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.GenerarConciliacion;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IGenerarConciliacionMapper extends IMantenibleMapper<GenerarConciliacion> {
	
	List<GenerarConciliacion> buscarCamposTablaObservada();
	
	GenerarConciliacion buscarPorIdConcTabla(Integer idConcTabla);
	
}
