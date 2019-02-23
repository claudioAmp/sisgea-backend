package ob.unibanca.sicf.mantenimientosgenerales.service.institucion;

import ob.unibanca.sicf.mantenimientosgenerales.mapper.base.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.base.MantenibleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstitucionService extends MantenibleService<Institucion> implements IInstitucionService {
	
	public InstitucionService(@Qualifier("IInstitucionMapper") IMantenibleMapper<Institucion> mantenibleMapper) {
		super(mantenibleMapper);
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
	public void eliminarInstitucion(int idInstitucion) {
		Institucion institucion = Institucion.builder().idInstitucion(idInstitucion).build(); this.eliminar(
				institucion);
	}
}
