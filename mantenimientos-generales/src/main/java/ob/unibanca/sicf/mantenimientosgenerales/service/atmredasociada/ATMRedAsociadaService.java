package ob.unibanca.sicf.mantenimientosgenerales.service.atmredasociada;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IATMRedAsociadaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedAsociada;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ATMRedAsociadaService extends MantenibleService<ATMRedAsociada> implements IATMRedAsociadaService {
	
	private static final int TIPO_ASOCIADA = 2;
	private static final String ATM_RED_ASOCIADA_NO_ENCONTRADO =
			"El ATM red asociada %d asociado a la " + "Institución %d no fue encontrado";
	
	private final IATMRedAsociadaMapper atmRedAsociadaMapper;
	
	public ATMRedAsociadaService(
			@Qualifier("IATMRedAsociadaMapper") IMantenibleMapper<ATMRedAsociada> mantenibleMapper) {
		super(mantenibleMapper);
		this.atmRedAsociadaMapper = (IATMRedAsociadaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ATMRedAsociada> buscarTodosATMsRedAsociada() {
		return super.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ATMRedAsociada buscarATMRedAsociada(int idATM, int idInstitucion) {
		return atmRedAsociadaMapper.buscarUno(idATM, idInstitucion).orElseThrow(
				() -> new RecursoNoEncontradoException(ATM_RED_ASOCIADA_NO_ENCONTRADO, idATM, idInstitucion));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ATMRedAsociada> buscarATMsRedAsociadaInstitucion(int idInstitucion) {
		return atmRedAsociadaMapper.buscarATMsRedAsociadaInstitucion(idInstitucion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ATMRedAsociada registrarATMRedAsociada(int idInstitucion, ATMRedAsociada atmRedAsociada) {
		atmRedAsociada.setTipo(TIPO_ASOCIADA);
		atmRedAsociada.setIdInstitucion(idInstitucion);
		super.registrar(atmRedAsociada);
		return this.buscarATMRedAsociada(atmRedAsociada.getIdATM(), atmRedAsociada.getIdInstitucion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ATMRedAsociada actualizarATMRedAsociada(int idATM, int idInstitucion, ATMRedAsociada atmRedAsociada) {
		atmRedAsociada.setTipo(TIPO_ASOCIADA);
		atmRedAsociada.setIdATM(idATM);
		atmRedAsociada.setIdInstitucion(idInstitucion);
		super.actualizar(atmRedAsociada);
		return this.buscarATMRedAsociada(atmRedAsociada.getIdATM(), atmRedAsociada.getIdInstitucion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarATMRedAsociada(int idATM, int idInstitucion) {
		ATMRedAsociada atmRedAsociada = ATMRedAsociada.builder().idATM(idATM).idInstitucion(idInstitucion).build();
		super.eliminar(atmRedAsociada);
	}
	
}
