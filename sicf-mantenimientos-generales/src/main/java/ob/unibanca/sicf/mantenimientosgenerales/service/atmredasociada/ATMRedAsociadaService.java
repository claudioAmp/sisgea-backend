package ob.unibanca.sicf.mantenimientosgenerales.service.atmredasociada;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IATMRedAsociadaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedAsociada;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedUnicard;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ATMRedAsociadaService extends MantenibleService<ATMRedAsociada> implements IATMRedAsociadaService {
	
	private static final int TIPO_ASOCIADA = 2;
	private static final String ATM_RED_ASOCIADA_NO_ENCONTRADO =
			"No existe la asociación entre el ATM red asociada %d y la Institución %d";
	private final IATMRedAsociadaMapper atmRedAsociadaMapper;
	
	public ATMRedAsociadaService(
			@Qualifier("IATMRedAsociadaMapper") IMantenibleMapper<ATMRedAsociada> mantenibleMapper) {
		super(mantenibleMapper);
		this.atmRedAsociadaMapper = (IATMRedAsociadaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ATMRedAsociada> buscarATMsRedAsociadaPorInstitucion(int idInstitucion) {
		return this.atmRedAsociadaMapper.buscarATMsRedAsociadaPorInstitucion(idInstitucion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ATMRedAsociada registrarATMRedAsociada(int idInstitucion, ATMRedAsociada atmRedAsociada) {
		atmRedAsociada.setTipo(TIPO_ASOCIADA);
		atmRedAsociada.setIdInstitucion(idInstitucion);
		this.registrar(atmRedAsociada);
		return this.buscarATMRedAsociada(atmRedAsociada.getIdATM(), atmRedAsociada.getIdInstitucion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ATMRedAsociada actualizarATMRedAsociada(int idATM, int idInstitucion, ATMRedAsociada atmRedAsociada) {
		atmRedAsociada.setTipo(TIPO_ASOCIADA);
		atmRedAsociada.setIdATM(idATM);
		atmRedAsociada.setIdInstitucion(idInstitucion);
		this.actualizar(atmRedAsociada);
		return this.buscarATMRedAsociada(atmRedAsociada.getIdATM(), atmRedAsociada.getIdInstitucion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarATMRedAsociada(int idATM, int idInstitucion) {
		ATMRedAsociada atmRedAsociada = ATMRedAsociada.builder().tipo(TIPO_ASOCIADA).idATM(idATM).idInstitucion(idInstitucion).build();
		this.eliminar(atmRedAsociada);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ATMRedAsociada> buscarTodosATMsRedAsociada() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ATMRedAsociada buscarATMRedAsociada(int idATM, int idInstitucion) {
		return this.atmRedAsociadaMapper.buscarATMRedAsociada(idATM, idInstitucion).orElseThrow(
				() -> new RecursoNoEncontradoException(ATM_RED_ASOCIADA_NO_ENCONTRADO, idATM, idInstitucion));
	}
}