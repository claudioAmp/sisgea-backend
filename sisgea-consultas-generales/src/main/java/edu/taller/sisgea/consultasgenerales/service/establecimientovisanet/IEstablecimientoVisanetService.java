package edu.taller.sisgea.consultasgenerales.service.establecimientovisanet;

import java.util.List;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanet;
import edu.taller.sisgea.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanetComis;
import edu.taller.sisgea.consultasgenerales.model.criterio.establecimientovisanet.CriterioBusquedaEstablecimientoVisanet;

public interface IEstablecimientoVisanetService {
	
	Page<EstablecimientoVisanet> buscarPorCriterios(CriterioBusquedaEstablecimientoVisanet criterioPaginacion, int pageNo, int pageSize);
	
	List<EstablecimientoVisanetComis> buscarComisionesPorSecuencia(CriterioBusquedaEstablecimientoVisanet criterio);
	
}
