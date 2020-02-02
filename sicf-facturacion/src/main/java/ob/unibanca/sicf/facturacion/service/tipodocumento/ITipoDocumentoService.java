package ob.unibanca.sicf.facturacion.service.tipodocumento;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.TipoDocumento;

public interface ITipoDocumentoService extends IMantenibleService<TipoDocumento> {
	List<TipoDocumento> buscarTodosTipoDocumento();
	TipoDocumento registrarTipoDocumento(TipoDocumento tipoDocumento);
	TipoDocumento actualizarTipoDocumento(int idDocumento,TipoDocumento TipoDocumento);
	void eliminarTipoDocumento(int idDocumento);
}
