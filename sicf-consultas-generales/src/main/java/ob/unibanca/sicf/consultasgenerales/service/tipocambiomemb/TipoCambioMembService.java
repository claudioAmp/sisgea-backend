package ob.unibanca.sicf.consultasgenerales.service.tipocambiomemb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.consultasgenerales.mapper.ITipoCambioMembMapper;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;
//import ob.unibanca.sicf.mantenimientosgenerales.service.parametrosistema.IParametroSistemaService;

@Service
public class TipoCambioMembService extends MantenibleService<TipoCambioMemb> implements ITipoCambioMembService{
	
	private final ITipoCambioMembMapper tipoCambioMembMapper;
	//@Autowired IParametroSistemaService parametroSistemaService;
	
	public TipoCambioMembService(@Qualifier("ITipoCambioMembMapper") IMantenibleMapper<TipoCambioMemb> mantenibleMapper) {
		super(mantenibleMapper);
		this.tipoCambioMembMapper = (ITipoCambioMembMapper) mantenibleMapper;
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
		System.out.println(tipoCambio);
		System.out.println(this.tipoCambioMembMapper.buscarPorIdTipoCambio(tipoCambio).get(0));
		return this.tipoCambioMembMapper.buscarPorIdTipoCambio(tipoCambio).get(0);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoCambioMemb actualizarTipoCambio(TipoCambioMemb tipoCambio) {
		this.actualizar(tipoCambio);
		System.out.println(tipoCambio);
		System.out.println(this.tipoCambioMembMapper.buscarPorIdTipoCambio(tipoCambio).get(0));
		return this.tipoCambioMembMapper.buscarPorIdTipoCambio(tipoCambio).get(0);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTipoCambio(TipoCambioMemb tipoCambio) {
		this.eliminar(tipoCambio);
	}
}
