package ob.unibanca.sicf.tarifarios.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.GrupoBINTarifa;

@Mapper
public interface IGrupoBINTarifaMapper extends IMantenibleMapper<GrupoBINTarifa>{
	
	Optional<GrupoBINTarifa> buscarGrupoBINTarifa(int idGrupoBIN, String idBIN);
	
	List<GrupoBINTarifa> buscarGrupoBINTarifaPorBIN(String idBIN);

}