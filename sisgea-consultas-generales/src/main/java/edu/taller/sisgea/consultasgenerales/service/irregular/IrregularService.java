package edu.taller.sisgea.consultasgenerales.service.irregular;


import edu.taller.sisgea.consultasgenerales.mapper.IIrregularMapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import edu.taller.sisgea.consultasgenerales.model.irregular.Irregular;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.IIrregularMapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import edu.taller.sisgea.consultasgenerales.model.irregular.Irregular;


@Service
public class IrregularService  implements IIrregularService{
	private final IIrregularMapper irregularMapper;
	
	public IrregularService(IIrregularMapper irregularMapper) {
		this.irregularMapper = irregularMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Irregular> buscarPorCriteriosIrregulares(CriterioBusquedaIrregular criterio, int pageNo,
                                                         int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println("service");
		return irregularMapper.buscarPorCriteriosIrregulares(criterio);
	}


}
