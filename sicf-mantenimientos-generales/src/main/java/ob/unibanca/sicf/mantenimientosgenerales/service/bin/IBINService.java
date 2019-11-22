package ob.unibanca.sicf.mantenimientosgenerales.service.bin;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN;
import ob.unibanca.sicf.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;

import java.util.List;

public interface IBINService extends IMantenibleService<BIN> {
	
	List<BIN> buscarTodosBIN();
	
	List<BIN> buscarPorInstituciones(CriterioBusquedaInstitucion criterio);
	
	BIN buscarBIN(String idBIN);
	
	BIN registrarBIN(BIN bin);
	
	BIN actualizarBIN(String idBIN, BIN bin);
	
	void eliminarBIN(String idBIN);
}