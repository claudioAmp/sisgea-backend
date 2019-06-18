package ob.unibanca.sicf.mantenimientosgenerales.service.categorianegocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.ICategoriaNegocioMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CategoriaNegocio;




@Service
public class CategoriaNegocioService  extends MantenibleService<CategoriaNegocio> implements ICategoriaNegocioService{
	
	private final ICategoriaNegocioMapper categoriaNegocioMapper;
	
	public CategoriaNegocioService(@Qualifier("ICategoriaNegocioMapper") IMantenibleMapper<CategoriaNegocio> mantenibleMapper) {
		super(mantenibleMapper);
		this.categoriaNegocioMapper = (ICategoriaNegocioMapper) mantenibleMapper;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CategoriaNegocio> buscarTodosCategoriasNegocios() {
		return this.buscarTodos();
	}
}
