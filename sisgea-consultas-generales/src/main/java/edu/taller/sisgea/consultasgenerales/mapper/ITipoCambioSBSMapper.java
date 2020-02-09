package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITipoCambioSBSMapper extends IMantenibleMapper<TipoCambioSBS> {
	
	public List<TipoCambioSBS> buscarIdTipoCambio(TipoCambioSBS tipoCambioSBS);
}
