package edu.taller.sisgea.tarifarios.service.grupobintarifa;

import java.util.List;

import edu.taller.sisgea.tarifarios.model.GrupoBINTarifa;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface IGrupoBINTarifaService extends IMantenibleService<GrupoBINTarifa>{
	
	List<GrupoBINTarifa> buscarTodosGruposBIN();
	
	List<GrupoBINTarifa> buscarTodosGruposBINAgrupado();

	List<GrupoBINTarifa> buscarGrupoBINTarifaPorBIN(String idBIN);

	GrupoBINTarifa registrarGrupoBINTarifa(String idBIN, GrupoBINTarifa grupoBINTarifa);

	GrupoBINTarifa actualizarGrupoBINTarifa(int idGrupoBIN, String idBIN, GrupoBINTarifa grupoBINTarifa);

	void eliminarGrupoBINTarifa(int idGrupoBIN, String idBIN);

	GrupoBINTarifa buscarGrupoBINTarifa(int idGrupoBIN, String idBIN);

}
