package edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc10;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.IIncomingVisaTC10Mapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomingVisaTC10Service implements IIncomingVisaTC10Service {
	
	private final IIncomingVisaTC10Mapper incomingVisaTC10Mapper;
	
	public IncomingVisaTC10Service(IIncomingVisaTC10Mapper incomingVisaTC10Mapper) {
		this.incomingVisaTC10Mapper = incomingVisaTC10Mapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(CriterioBusquedaIncomingVisaTC10 criterioBusqueda,
                                                                     int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return incomingVisaTC10Mapper.buscarPorCriteriosTCR0(criterioBusqueda);
	}
}
