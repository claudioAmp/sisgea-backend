package ob.unibanca.sicf.mantenimientosgenerales.service.institucion;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstitucionService extends MantenibleService<Institucion> implements IInstitucionService {
	
	public InstitucionService(@Qualifier("IInstitucionMapper") IMantenibleMapper<Institucion> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Institucion> buscarTodosInstituciones() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registrarInstitucion(Institucion institucion) {
		this.registrar(institucion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void actualizarInstitucion(Institucion institucion) {
		this.actualizar(institucion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarInstitucion(Institucion institucion) {
		this.eliminar(institucion);
	}
}
