package edu.taller.sisgea.reportes.service.control.vssvisa;

import java.util.ArrayList;
import java.util.List;

import edu.taller.sisgea.reportes.mapper.control.IReporteControlVSSVisaMapper;
import edu.taller.sisgea.reportes.model.control.criterio.CriterioBusquedaReporteControlVSSVisa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.taller.sisgea.reportes.model.control.ReporteControlVSSVisa;

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
