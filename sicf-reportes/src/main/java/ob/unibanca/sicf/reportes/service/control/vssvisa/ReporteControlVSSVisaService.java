package ob.unibanca.sicf.reportes.service.control.vssvisa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.unibanca.sicf.reportes.mapper.control.IReporteControlVSSVisaMapper;
import ob.unibanca.sicf.reportes.model.control.ReporteControlVSSVisa;
import ob.unibanca.sicf.reportes.model.control.criterio.CriterioBusquedaReporteControlVSSVisa;

@Service
public class ReporteControlVSSVisaService implements IReporteControlVSSVisaService {
	
	private final IReporteControlVSSVisaMapper reporteControlVSSVisaMapper; 
	
	public ReporteControlVSSVisaService(IReporteControlVSSVisaMapper mantenibleMapper) {
		this.reporteControlVSSVisaMapper = (IReporteControlVSSVisaMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ReporteControlVSSVisa> buscarPorFechaProceso(CriterioBusquedaReporteControlVSSVisa criterio){
		List<ReporteControlVSSVisa> reporteControlVSSVisa = new ArrayList<>();
		criterio.setResultado(reporteControlVSSVisa);
		this.reporteControlVSSVisaMapper.buscarPorFechaProceso(criterio);
		return criterio.getResultado();
	}
	
}
