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
	public Institucion registrarInstitucion(Institucion institucion) {
		this.registrar(institucion); return institucion;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Institucion actualizarInstitucion(int idInstitucion, Institucion institucion) {
		institucion.setIdInstitucion(idInstitucion); this.actualizar(institucion); return institucion;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarInstitucion(int idInstitucion) {
		Institucion institucion = Institucion.builder().idInstitucion(idInstitucion).build();
		this.eliminar(institucion);
	}
}
