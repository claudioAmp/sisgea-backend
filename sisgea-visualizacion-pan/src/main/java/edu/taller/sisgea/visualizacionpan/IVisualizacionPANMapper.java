package edu.taller.sisgea.visualizacionpan;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IVisualizacionPANMapper {
	
	Boolean puedeVisualizarPAN(String username, String codigoAudiencia);
	
}
