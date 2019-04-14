package ob.unibanca.sicf.mantenimientosgenerales.service.correotelefono;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.ICorreoTelefonoMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CorreoTelefono;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CorreoTelefonoService extends MantenibleService<CorreoTelefono> implements ICorreoTelefonoService {
	
	private static final String CORREO_TELEFONO_NO_ENCONTRADO =
			"No existe la asociación entre el correo / telefono %s y la membresía %s";
	private final ICorreoTelefonoMapper correoTelefonoMapper;
	
	public CorreoTelefonoService(@Qualifier("ICorreoTelefonoMapper") IMantenibleMapper<CorreoTelefono> mantenibleMapper) {
		super(mantenibleMapper);
		this.correoTelefonoMapper = (ICorreoTelefonoMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public CorreoTelefono registrarCorreoTelefono(String idMembresia, CorreoTelefono correoTelefono) {
		correoTelefono.setIdMembresia(idMembresia);
		this.registrar(correoTelefono);
		return this.buscarCorreoTelefono(correoTelefono.getIdMembresia(), correoTelefono.getIdCorreoTelefono());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CorreoTelefono actualizarCorreoTelefono(String idMembresia, String idCorreoTelefono, CorreoTelefono correoTelefono) {
		correoTelefono.setIdMembresia(idMembresia);
		correoTelefono.setIdCorreoTelefono(idCorreoTelefono);
		this.actualizar(correoTelefono);
		return this.buscarCorreoTelefono(correoTelefono.getIdMembresia(), correoTelefono.getIdCorreoTelefono());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCorreoTelefono(String idMembresia, String idCorreoTelefono) {
		CorreoTelefono correoTelefono = CorreoTelefono.builder().idMembresia(idMembresia).idCorreoTelefono(idCorreoTelefono).build();
		this.eliminar(correoTelefono);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CorreoTelefono> buscarTodosCorreoTelefono() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CorreoTelefono buscarCorreoTelefono(String idMembresia, String idCorreoTelefono) {
		return this.correoTelefonoMapper.buscarCorreoTelefono(idMembresia, idCorreoTelefono).orElseThrow(
				() -> new RecursoNoEncontradoException(CORREO_TELEFONO_NO_ENCONTRADO, idCorreoTelefono, idMembresia));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CorreoTelefono> buscarCorreoTelefonoPorMembresia(String idMembresia) {
		return this.correoTelefonoMapper.buscarCorreoTelefonoPorMembresia(idMembresia);
	}
}
