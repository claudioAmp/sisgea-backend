package edu.taller.sisgea.consultasgenerales.service.tipocambiomemb;

import java.util.List;

import edu.taller.sisgea.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;

public interface ITipoCambioMembService {
	
	public List<TipoCambioMemb> buscarTodosTipoCambio();
		
	public TipoCambioMemb registrarTipoCambio(TipoCambioMemb tipoCambioMemb);
	
	public TipoCambioMemb actualizarTipoCambio(TipoCambioMemb tipoCambioMemb);
	
	public void eliminarTipoCambio(TipoCambioMemb tipoCambioMemb);
}
