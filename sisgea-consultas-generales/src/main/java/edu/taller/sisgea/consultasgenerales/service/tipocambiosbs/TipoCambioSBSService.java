package edu.taller.sisgea.consultasgenerales.service.tipocambiosbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.consultasgenerales.mapper.ITipoCambioSBSMapper;
import edu.taller.sisgea.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;;

@Service
public class TipoCambioSBSService extends MantenibleService<TipoCambioSBS> implements ITipoCambioSBSService{
	
	private final ITipoCambioSBSMapper tipoCambioSBSMapper;
	
	public TipoCambioSBSService(@Qualifier("ITipoCambioSBSMapper") IMantenibleMapper<TipoCambioSBS> mantenibleMapper) {
		super(mantenibleMapper);
		this.tipoCambioSBSMapper = (ITipoCambioSBSMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoCambioSBS> buscarTodosTipoCambio() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoCambioSBS> buscarIdTipoCambio(TipoCambioSBS tipoCambioSBS){
		return this.tipoCambioSBSMapper.buscarIdTipoCambio(tipoCambioSBS);
	}
			
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoCambioSBS registrarTipoCambio(TipoCambioSBS tipoCambio) {
		this.registrar(tipoCambio);
		return this.tipoCambioSBSMapper.buscarIdTipoCambio(tipoCambio).get(0);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoCambioSBS actualizarTipoCambio(TipoCambioSBS tipoCambio) {
		this.actualizar(tipoCambio);
		return this.tipoCambioSBSMapper.buscarIdTipoCambio(tipoCambio).get(0);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTipoCambio(TipoCambioSBS tipoCambio) {
		this.eliminar(tipoCambio);
	}
}
