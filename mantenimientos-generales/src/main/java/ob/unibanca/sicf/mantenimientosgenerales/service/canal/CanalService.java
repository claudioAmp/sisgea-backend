package ob.unibanca.sicf.mantenimientosgenerales.service.canal;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Canal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CanalService extends MantenibleService<Canal> implements ICanalService {
	
	public CanalService(@Qualifier("ICanalMapper") IMantenibleMapper<Canal> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Canal> buscarTodosCanales() {
		return super.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Canal registrarCanal(Canal canal) {
		super.registrar(canal);
		return canal;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Canal actualizarCanal(int idCanal, Canal canal) {
		canal.setIdCanal(idCanal);
		super.actualizar(canal);
		return canal;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCanal(int idCanal) {
		Canal canal = Canal.builder().idCanal(idCanal).build();
		super.eliminar(canal);
	}
}
