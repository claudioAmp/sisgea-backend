package edu.taller.sisgea.mantenimientosgenerales.service.bin;

import edu.taller.sisgea.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;
import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.BIN;

import java.util.List;

public interface IBINService extends IMantenibleService<BIN> {
	
	List<BIN> buscarTodosBIN();
	
	List<BIN> buscarPorInstituciones(CriterioBusquedaInstitucion criterio);
	
	BIN buscarBIN(String idBIN);
	
	BIN registrarBIN(BIN bin);
	
	BIN actualizarBIN(String idBIN, BIN bin);
	
	void eliminarBIN(String idBIN);
}