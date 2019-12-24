package ob.unibanca.sicf.consultasgenerales.service.tipocambiosbs;

import java.util.List;

import ob.unibanca.sicf.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;

public interface ITipoCambioSBSService {
	
	public List<TipoCambioSBS> buscarTodosTipoCambio();
	
	public List<TipoCambioSBS> buscarIdTipoCambio(TipoCambioSBS tipoCambioSBS);
		
	public TipoCambioSBS registrarTipoCambio(TipoCambioSBS tipoCambioSBS);
	
	public TipoCambioSBS actualizarTipoCambio(TipoCambioSBS tipoCambioSBS);
	
	public void eliminarTipoCambio(TipoCambioSBS tipoCambioSBS);
}
