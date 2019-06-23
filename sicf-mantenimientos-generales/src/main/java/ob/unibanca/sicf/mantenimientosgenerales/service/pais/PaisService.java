package ob.unibanca.sicf.mantenimientosgenerales.service.pais;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IPaisMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Pais;


@Service
public class PaisService  extends MantenibleService<Pais> implements IPaisService {

	private final IPaisMapper paisMapper;
	
	public PaisService(@Qualifier("IPaisMapper") IMantenibleMapper<Pais> mantenibleMapper) {
		super(mantenibleMapper);
		this.paisMapper = (IPaisMapper) mantenibleMapper;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Pais> buscarTodosPaises(){
		
		return this.buscarTodos();
	}
	
	
}
