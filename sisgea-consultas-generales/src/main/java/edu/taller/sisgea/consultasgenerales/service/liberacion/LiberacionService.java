package edu.taller.sisgea.consultasgenerales.service.liberacion;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.ILiberacionMapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;
import edu.taller.sisgea.consultasgenerales.model.liberacion.Liberacion;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import edu.taller.sisgea.consultasgenerales.mapper.ILiberacionMapper;
import edu.taller.sisgea.consultasgenerales.model.liberacion.Liberacion;
import edu.taller.sisgea.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LiberacionService implements ILiberacionService {
	
	private final ILiberacionMapper liberacionMapper;
	
	public LiberacionService(ILiberacionMapper liberacionMapper) {
		this.liberacionMapper = liberacionMapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Liberacion> buscarPorCriterios(CriterioBusquedaLiberacion criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return liberacionMapper.buscarPorCriterios(criterioPaginacion);
	}
	
}
