package ob.unibanca.sicf.consultasgenerales.service.irregular;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IIrregularMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import ob.unibanca.sicf.consultasgenerales.model.irregular.Irregular;


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
		
		return irregularMapper.buscarPorCriteriosIrregulares(criterio);
	}


}
