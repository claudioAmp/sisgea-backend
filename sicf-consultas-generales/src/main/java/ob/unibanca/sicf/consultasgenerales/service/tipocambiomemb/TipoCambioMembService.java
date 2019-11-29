package ob.unibanca.sicf.consultasgenerales.service.tipocambiomemb;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;

@Service
public class TipoCambioMembService extends MantenibleService<TipoCambioMemb> implements ITipoCambioMembService{
	
	public TipoCambioMembService(@Qualifier("ITipoCambioMembMapper") IMantenibleMapper<TipoCambioMemb> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoCambioMemb> buscarTodosTipoCambio() {
		return this.buscarTodos();
	}
		
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoCambioMemb registrarTipoCambio(TipoCambioMemb tipoCambio) {
		this.registrar(tipoCambio);
		return tipoCambio;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoCambioMemb actualizarTipoCambio(TipoCambioMemb tipoCambio) {
		this.actualizar(tipoCambio);
		return tipoCambio;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTipoCambio(TipoCambioMemb tipoCambio) {
		this.eliminar(tipoCambio);
	}
}
