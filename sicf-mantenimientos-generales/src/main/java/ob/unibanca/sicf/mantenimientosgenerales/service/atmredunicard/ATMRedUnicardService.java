package ob.unibanca.sicf.mantenimientosgenerales.service.atmredunicard;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IATMRedUnicardMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedUnicard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ATMRedUnicardService extends MantenibleService<ATMRedUnicard> implements IATMRedUnicardService {
	
	private static final int TIPO_UNICARD = 1;
	private static final String ATM_RED_UNICARD_NO_ENCONTRADO = "El ATM red UNICARD %d no existe";
	
	private final IATMRedUnicardMapper atmRedUnicardMapper;
	
	public ATMRedUnicardService(@Qualifier("IATMRedUnicardMapper") IMantenibleMapper<ATMRedUnicard> mantenibleMapper) {
		super(mantenibleMapper);
		this.atmRedUnicardMapper = (IATMRedUnicardMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ATMRedUnicard registrarATMRedUnicard(ATMRedUnicard atmRedUnicard) {
		atmRedUnicard.setTipo(TIPO_UNICARD);
		super.registrar(atmRedUnicard);
		return this.buscarATMRedUnicard(atmRedUnicard.getIdATM());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ATMRedUnicard actualizarATMRedUnicard(int idATM, ATMRedUnicard atmRedUnicard) {
		atmRedUnicard.setTipo(TIPO_UNICARD);
		atmRedUnicard.setIdATM(idATM);
		super.actualizar(atmRedUnicard);
		return this.buscarATMRedUnicard(atmRedUnicard.getIdATM());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarATMRedUnicard(int idATM) {
		ATMRedUnicard atmRedUnicard = ATMRedUnicard.builder().tipo(TIPO_UNICARD).idATM(idATM).build();
		super.eliminar(atmRedUnicard);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ATMRedUnicard> buscarTodosATMsRedUnicard() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ATMRedUnicard buscarATMRedUnicard(int idATM) {
		return this.atmRedUnicardMapper.buscarATMRedUnicard(idATM).orElseThrow(
				() -> new RecursoNoEncontradoException(ATM_RED_UNICARD_NO_ENCONTRADO, idATM));
	}
}
