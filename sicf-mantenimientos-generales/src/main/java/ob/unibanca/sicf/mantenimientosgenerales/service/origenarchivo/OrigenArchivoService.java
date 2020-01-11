package ob.unibanca.sicf.mantenimientosgenerales.service.origenarchivo;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IOrigenArchivoMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.OrigenArchivo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrigenArchivoService extends MantenibleService<OrigenArchivo> implements IOrigenArchivoService {
	
	private static final String ORIGEN_ARCHIVO_NO_ENCONTRADO = "El Origen Archivo %s no existe";
	private final IOrigenArchivoMapper origenArchivoMapper;
	
	public OrigenArchivoService(@Qualifier("IOrigenArchivoMapper") IMantenibleMapper<OrigenArchivo> mantenibleMapper) {
		super(mantenibleMapper);
		this.origenArchivoMapper = (IOrigenArchivoMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<OrigenArchivo> buscarTodosOrigenArchivo() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public OrigenArchivo buscarOrigenArchivo(String idOrigenArchivo) {
		return this.origenArchivoMapper.buscarOrigenArchivo(idOrigenArchivo).orElseThrow(
				() -> new RecursoNoEncontradoException(ORIGEN_ARCHIVO_NO_ENCONTRADO, idOrigenArchivo));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<OrigenArchivo> buscarOrigenArchivoPorConciliacion(boolean concilia) {
		return this.origenArchivoMapper.buscarOrigenArchivoPorConciliacion(concilia);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public OrigenArchivo registrarOrigenArchivo(OrigenArchivo origenArchivo) {
		this.registrar(origenArchivo);
		return origenArchivo;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public OrigenArchivo actualizarOrigenArchivo(String idOrigenArchivo, OrigenArchivo origenArchivo) {
		origenArchivo.setIdOrigenArchivo(idOrigenArchivo);
		this.actualizar(origenArchivo);
		return origenArchivo;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarOrigenArchivo(String idOrigenArchivo) {
		OrigenArchivo origenArchivo = OrigenArchivo.builder().idOrigenArchivo(idOrigenArchivo).build();
		this.eliminar(origenArchivo);
	}
	
}
