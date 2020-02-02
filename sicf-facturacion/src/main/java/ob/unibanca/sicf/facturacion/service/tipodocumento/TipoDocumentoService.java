package ob.unibanca.sicf.facturacion.service.tipodocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.facturacion.model.TipoDocumento;

@Service
public class TipoDocumentoService  extends MantenibleService<TipoDocumento> implements ITipoDocumentoService{

	public TipoDocumentoService(@Qualifier("ITipoDocumentoMapper") IMantenibleMapper<TipoDocumento> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoDocumento> buscarTodosTipoDocumento() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoDocumento registrarTipoDocumento(TipoDocumento tipoDocumento) {
		this.registrar(tipoDocumento);
		return tipoDocumento;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoDocumento actualizarTipoDocumento(int idDocumento, TipoDocumento TipoDocumento) {
		TipoDocumento.setIdDocumento(idDocumento);
		return TipoDocumento;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTipoDocumento(int idDocumento) {
		TipoDocumento tipoDocumento = TipoDocumento.builder().idDocumento(idDocumento).build();
		this.eliminar(tipoDocumento);
		
	}

}
