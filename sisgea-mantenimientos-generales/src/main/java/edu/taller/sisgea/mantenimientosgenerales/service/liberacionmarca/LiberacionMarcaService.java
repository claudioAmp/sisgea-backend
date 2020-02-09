package edu.taller.sisgea.mantenimientosgenerales.service.liberacionmarca;

import edu.taller.sisgea.mantenimientosgenerales.mapper.ILiberacionMarcaMapper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.LiberacionMarca;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LiberacionMarcaService extends MantenibleService<LiberacionMarca> implements ILiberacionMarcaService {
	
	private static final String LIBERACION_MARCA_NO_ENCONTRADO = "No existe la asociación entre el liberacionMarca %s y la membresía %s";
	private final ILiberacionMarcaMapper liberacionMarcaMapper;
	
	public LiberacionMarcaService(@Qualifier("ILiberacionMarcaMapper") IMantenibleMapper<LiberacionMarca> mantenibleMapper) {
		super(mantenibleMapper);
		this.liberacionMarcaMapper = (ILiberacionMarcaMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public LiberacionMarca registrarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso, LiberacionMarca liberacionMarca) {
		liberacionMarca.setIdMembresia(idMembresia);
		liberacionMarca.setIdProducto(idProducto);
		liberacionMarca.setIdProceso(idProceso);
		this.registrar(liberacionMarca);
		return this.buscarLiberacionMarca(liberacionMarca.getIdMembresia(), liberacionMarca.getIdProducto(), liberacionMarca.getIdProceso());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public LiberacionMarca actualizarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso, LiberacionMarca liberacionMarca) {
		liberacionMarca.setIdMembresia(idMembresia);
		liberacionMarca.setIdProducto(idProducto);
		liberacionMarca.setIdProceso(idProceso);
		this.actualizar(liberacionMarca);
		return this.buscarLiberacionMarca(liberacionMarca.getIdMembresia(), liberacionMarca.getIdProducto(), liberacionMarca.getIdProceso());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso) {
		LiberacionMarca liberacionMarca = LiberacionMarca.builder().idMembresia(idMembresia).idProducto(idProducto).idProceso(idProceso).build();
		this.eliminar(liberacionMarca);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<LiberacionMarca> buscarTodosLiberacionMarcas() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public LiberacionMarca buscarLiberacionMarca(String idMembresia, Integer idProducto, String idProceso) {
		return this.liberacionMarcaMapper.buscarLiberacionMarca(idMembresia, idProducto, idProceso).orElseThrow(
				() -> new RecursoNoEncontradoException(LIBERACION_MARCA_NO_ENCONTRADO, idMembresia, idProducto, idProceso));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<LiberacionMarca> buscarLiberacionMarcasPorMembresia(String idMembresia) {
		return this.liberacionMarcaMapper.buscarLiberacionMarcasPorMembresia(idMembresia);
	}
}
