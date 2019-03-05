package ob.unibanca.sicf.mantenimientosgenerales.service.multitabdet;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IMultitabDetMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.MultitabDet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MultitabDetService extends MantenibleService<MultitabDet> implements IMultitabDetService {
	
	private static final String MULTITAB_DET_NO_ENCONTRADO =
			"La Multitab Det %s asociado a la Multitab Cab %d no fue encontrado";
	
	private final IMultitabDetMapper multitabDetMapper;
	
	public MultitabDetService(@Qualifier("IMultitabDetMapper") IMantenibleMapper<MultitabDet> mantenibleMapper) {
		super(mantenibleMapper);
		this.multitabDetMapper = (IMultitabDetMapper) mantenibleMapper;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<MultitabDet> buscarTodosMultitabsDet() {
		return super.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public MultitabDet buscarMultitabDet(int idMultitabCab, String idMultitabDet) {
		return this.multitabDetMapper.buscarUno(idMultitabCab, idMultitabDet).orElseThrow(
				() -> new RecursoNoEncontradoException(MULTITAB_DET_NO_ENCONTRADO, idMultitabDet, idMultitabCab));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<MultitabDet> buscarMultitabsDetMultitabCab(int idMultitabCab) {
		return this.multitabDetMapper.buscarMultitabsDetMultitabCab(idMultitabCab);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MultitabDet registrarMultitabDet(int idMultitabCab, MultitabDet multitabDet) {
		multitabDet.setIdMultitabCab(idMultitabCab);
		super.registrar(multitabDet);
		return this.buscarMultitabDet(multitabDet.getIdMultitabCab(), multitabDet.getIdMultitabDet());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MultitabDet actualizarMultitabDet(int idMultitabCab, String idMultitabDet, MultitabDet multitabDet) {
		multitabDet.setIdMultitabCab(idMultitabCab);
		multitabDet.setIdMultitabDet(idMultitabDet);
		super.actualizar(multitabDet);
		return this.buscarMultitabDet(multitabDet.getIdMultitabCab(), multitabDet.getIdMultitabDet());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarMultitabDet(int idMultitabCab, String idMultitabDet) {
		MultitabDet multitabDet = MultitabDet.builder().idMultitabCab(idMultitabCab).idMultitabDet(idMultitabDet)
		                                     .build();
		super.eliminar(multitabDet);
	}
}
