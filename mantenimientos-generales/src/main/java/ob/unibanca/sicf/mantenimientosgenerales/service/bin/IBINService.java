package ob.unibanca.sicf.mantenimientosgenerales.service.bin;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN;

import java.util.List;

public interface IBINService extends IMantenibleService<BIN> {
	
	List<BIN> buscarTodosBINs();
	
	BIN buscarBIN(String idBIN);
	
	BIN registrarBIN(BIN bin);
	
	BIN actualizarBIN(String idBIN, BIN bin);
	
	void eliminarBIN(String idBIN);
}