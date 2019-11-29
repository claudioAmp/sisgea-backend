package ob.unibanca.sicf.consultasgenerales.service.tipocambiomemb;

import java.util.List;

import ob.unibanca.sicf.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;

public interface ITipoCambioMembService {
	
	public List<TipoCambioMemb> buscarTodosTipoCambio();
		
	public TipoCambioMemb registrarTipoCambio(TipoCambioMemb tipoCambioMemb);
	
	public TipoCambioMemb actualizarTipoCambio(TipoCambioMemb tipoCambioMemb);
	
	public void eliminarTipoCambio(TipoCambioMemb tipoCambioMemb);
}
