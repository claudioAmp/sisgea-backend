package edu.taller.sisgea.generadorconsultas.mapper;


import edu.taller.sisgea.generadorconsultas.model.UltimoSecuencia;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IUltimoSecuenciaMapper {
	void obtenerUltimoSecuencia(UltimoSecuencia ultimoSecuencia);
	
}
