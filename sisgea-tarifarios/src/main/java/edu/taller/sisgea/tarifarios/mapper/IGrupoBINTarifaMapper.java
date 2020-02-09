package edu.taller.sisgea.tarifarios.mapper;

import java.util.List;
import java.util.Optional;

import edu.taller.sisgea.tarifarios.model.GrupoBINTarifa;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface IGrupoBINTarifaMapper extends IMantenibleMapper<GrupoBINTarifa>{
	
	Optional<GrupoBINTarifa> buscarGrupoBINTarifa(int idGrupoBIN, String idBIN);
	
	List<GrupoBINTarifa> buscarGrupoBINTarifaPorBIN(String idBIN);
	
	List<GrupoBINTarifa> buscarTodosAgrupado();

}
