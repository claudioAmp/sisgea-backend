package edu.taller.sisgea.mantenimientosgenerales.service.modoentradapos;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IModoEntradaPOSMapper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.ModoEntradaPOS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModoEntradaPOSService extends MantenibleService<ModoEntradaPOS> implements IModoEntradaPOSService {
	
	private static final String MODO_ENTRADA_POS_NO_ENCONTRADO =
			"No existe la asociación entre el modo de entrada POS %s y la membresía %s";
	private final IModoEntradaPOSMapper modoEntradaPOSMapper;
	
	public ModoEntradaPOSService(@Qualifier("IModoEntradaPOSMapper") IMantenibleMapper<ModoEntradaPOS> mantenibleMapper) {
		super(mantenibleMapper);
		this.modoEntradaPOSMapper = (IModoEntradaPOSMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public ModoEntradaPOS registrarModoEntradaPOS(String idMembresia, ModoEntradaPOS modoEntradaPOS) {
		modoEntradaPOS.setIdMembresia(idMembresia);
		this.registrar(modoEntradaPOS);
		return this.buscarModoEntradaPOS(modoEntradaPOS.getIdMembresia(), modoEntradaPOS.getIdModoEntradaPOS());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ModoEntradaPOS actualizarModoEntradaPOS(String idMembresia, String idModoEntradaPOS, ModoEntradaPOS modoEntradaPOS) {
		modoEntradaPOS.setIdMembresia(idMembresia);
		modoEntradaPOS.setIdModoEntradaPOS(idModoEntradaPOS);
		this.actualizar(modoEntradaPOS);
		return this.buscarModoEntradaPOS(modoEntradaPOS.getIdMembresia(), modoEntradaPOS.getIdModoEntradaPOS());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarModoEntradaPOS(String idMembresia, String idModoEntradaPOS) {
		ModoEntradaPOS modoEntradaPOS = ModoEntradaPOS.builder().idMembresia(idMembresia).idModoEntradaPOS(idModoEntradaPOS).build();
		this.eliminar(modoEntradaPOS);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ModoEntradaPOS> buscarTodosModosEntradasPOS() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ModoEntradaPOS buscarModoEntradaPOS(String idMembresia, String idModoEntradaPOS) {
		return this.modoEntradaPOSMapper.buscarModoEntradaPOS(idMembresia, idModoEntradaPOS).orElseThrow(
				() -> new RecursoNoEncontradoException(MODO_ENTRADA_POS_NO_ENCONTRADO, idModoEntradaPOS, idMembresia));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ModoEntradaPOS> buscarModosEntradasPOSPorMembresia(String idMembresia) {
		return this.modoEntradaPOSMapper.buscarModosEntradasPOSPorMembresia(idMembresia);
	}
}
