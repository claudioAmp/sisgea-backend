package ob.unibanca.sicf.facturacion.service.tiponota;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.facturacion.model.TipoNota;

@Service
public class TipoNotaService extends MantenibleService<TipoNota> implements ITipoNotaService {

	public TipoNotaService(@Qualifier("ITipoNotaMapper") IMantenibleMapper<TipoNota> mantenibleMapper) {
		super(mantenibleMapper);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoNota> buscarTodosTipoNota() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoNota registrarTipoNota(TipoNota tipoNota) {
		this.registrar(tipoNota);
		return tipoNota;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoNota actualizarTipoNota(int idOrigenNota, int idNota, TipoNota tipoNota) {
		tipoNota.setIdOrigenNota(idOrigenNota);
		tipoNota.setIdNota(idNota);
		this.actualizar(tipoNota);
		return tipoNota;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTipoNota(int idOrigenNota, int idNota) {
		TipoNota tipoNota = TipoNota.builder().idOrigenNota(idOrigenNota).idNota(idNota).build();
		this.eliminar(tipoNota);
	}

}
