package edu.taller.sisgea.tarifarios.service.grupobintarifa;

import java.util.List;

import edu.taller.sisgea.tarifarios.model.GrupoBINTarifa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.tarifarios.mapper.IGrupoBINTarifaMapper;

@Service
public class GrupoBINTarifaService extends MantenibleService<GrupoBINTarifa> implements IGrupoBINTarifaService{
	
	private static final String GRUPO_BIN_TARIFA_NO_ENCONTRADO =
			"No existe la asociación entre el Grupo BIN Tarifa %d y el BIN %d";
	private final IGrupoBINTarifaMapper grupoBINTarifaMapper;
	
	public GrupoBINTarifaService(
			@Qualifier("IGrupoBINTarifaMapper") IMantenibleMapper<GrupoBINTarifa> mantenibleMapper) {
		super(mantenibleMapper);
		this.grupoBINTarifaMapper = (IGrupoBINTarifaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<GrupoBINTarifa> buscarTodosGruposBIN(){
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<GrupoBINTarifa> buscarTodosGruposBINAgrupado(){
		return this.grupoBINTarifaMapper.buscarTodosAgrupado();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public GrupoBINTarifa buscarGrupoBINTarifa(int idGrupoBIN, String idBIN) {
		return this.grupoBINTarifaMapper.buscarGrupoBINTarifa(idGrupoBIN, idBIN).orElseThrow(
				() -> new RecursoNoEncontradoException(GRUPO_BIN_TARIFA_NO_ENCONTRADO, idGrupoBIN, idBIN));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GrupoBINTarifa registrarGrupoBINTarifa(String idBIN, GrupoBINTarifa grupoBINTarifa) {
		grupoBINTarifa.setIdBIN(idBIN);
		this.registrar(grupoBINTarifa);
		return this.buscarGrupoBINTarifa(grupoBINTarifa.getIdGrupoBIN(), grupoBINTarifa.getIdBIN());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GrupoBINTarifa actualizarGrupoBINTarifa(int idGrupoBIN, String idBIN, GrupoBINTarifa grupoBINTarifa) {
		grupoBINTarifa.setIdGrupoBIN(idGrupoBIN);
		grupoBINTarifa.setIdBIN(idBIN);
		this.actualizar(grupoBINTarifa);
		return this.buscarGrupoBINTarifa(grupoBINTarifa.getIdGrupoBIN(), grupoBINTarifa.getIdBIN());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarGrupoBINTarifa(int idGrupoBIN, String idBIN) {
		GrupoBINTarifa grupoBINTarifa = GrupoBINTarifa.builder().idGrupoBIN(idGrupoBIN).idBIN(idBIN).build();
		this.eliminar(grupoBINTarifa);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<GrupoBINTarifa> buscarGrupoBINTarifaPorBIN(String idBIN){
		return this.grupoBINTarifaMapper.buscarGrupoBINTarifaPorBIN(idBIN);
	}
}
