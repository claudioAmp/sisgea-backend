package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITipoCambioMembMapper extends IMantenibleMapper<TipoCambioMemb> {
	
	public List<TipoCambioMemb> buscarPorIdTipoCambio(TipoCambioMemb tipoCambioMemb);

}
