package ob.unibanca.sicf.consultasgenerales.service.tipocambiosbs;

import java.util.List;
import java.util.Optional;

import ob.unibanca.sicf.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;

public interface ITipoCambioSBSService {
	
	public List<TipoCambioSBS> buscarTodosTipoCambio();
		
	public TipoCambioSBS registrarTipoCambio(TipoCambioSBS tipoCambioMemb);
	
	public TipoCambioSBS actualizarTipoCambio(TipoCambioSBS tipoCambioMemb);
	
	public void eliminarTipoCambio(TipoCambioSBS tipoCambioMemb);
}
