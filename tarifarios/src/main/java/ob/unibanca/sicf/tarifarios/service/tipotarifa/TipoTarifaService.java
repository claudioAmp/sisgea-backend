package ob.unibanca.sicf.tarifarios.service.tipotarifa;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.tarifarios.mapper.ITipoTarifaMapper;
import ob.unibanca.sicf.tarifarios.model.TipoTarifa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoTarifaService extends MantenibleService<TipoTarifa> implements ITipoTarifaService {
	
	private static final String TIPO_TARIFA_NO_ENCONTRADO = "El Tipo de Tarifa %s no existe";
	private final ITipoTarifaMapper tipoTarifaMapper;
	
	public TipoTarifaService(@Qualifier("ITipoTarifaMapper") IMantenibleMapper<TipoTarifa> mantenibleMapper) {
		super(mantenibleMapper);
		this.tipoTarifaMapper = (ITipoTarifaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoTarifa registrarTipoTarifa(TipoTarifa tipoTarifa) {
		this.registrar(tipoTarifa);
		return this.buscarTipoTarifa(tipoTarifa.getIdTarifa());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoTarifa actualizarTipoTarifa(int idTarifa, TipoTarifa tipoTarifa) {
		tipoTarifa.setIdTarifa(idTarifa);
		this.actualizar(tipoTarifa);
		return this.buscarTipoTarifa(tipoTarifa.getIdTarifa());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTipoTarifa(int idTarifa) {
		TipoTarifa tipoTarifa = TipoTarifa.builder().idTarifa(idTarifa).build();
		this.eliminar(tipoTarifa);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoTarifa> buscarTodosTiposTarifas() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TipoTarifa buscarTipoTarifa(int idTarifa) {
		return this.tipoTarifaMapper.buscarTipoTarifa(idTarifa).orElseThrow(
				() -> new RecursoNoEncontradoException(TIPO_TARIFA_NO_ENCONTRADO, idTarifa));
	}

}
