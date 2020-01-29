package ob.unibanca.sicf.facturacion.service.tiponota;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.TipoNota;

public interface ITipoNotaService extends IMantenibleService<TipoNota> {
	List<TipoNota> buscarTodosTipoNota();
	TipoNota registrarTipoNota(TipoNota tipoNota);
	TipoNota actualizarTipoNota(int idOrigenNota, int idNota, TipoNota tipoNota);
	void eliminarTipoNota(int idOrigenNota, int idNota);
}
