package ob.unibanca.sicf.consultasgenerales.service.tipocambiosbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;;

@Service
public class TipoCambioSBSService extends MantenibleService<TipoCambioSBS> implements ITipoCambioSBSService{
	
	public TipoCambioSBSService(@Qualifier("ITipoCambioSBSMapper") IMantenibleMapper<TipoCambioSBS> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoCambioSBS> buscarTodosTipoCambio() {
		return this.buscarTodos();
	}
		
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoCambioSBS registrarTipoCambio(TipoCambioSBS tipoCambio) {
		this.registrar(tipoCambio);
		return tipoCambio;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoCambioSBS actualizarTipoCambio(TipoCambioSBS tipoCambio) {
		this.actualizar(tipoCambio);
		return tipoCambio;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTipoCambio(TipoCambioSBS tipoCambio) {
		this.eliminar(tipoCambio);
	}
}
