package ob.unibanca.sicf.consultasgenerales.service.establecimientovisanet;

import java.util.List;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanet;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanetComis;
import ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientovisanet.CriterioBusquedaEstablecimientoVisanet;

public interface IEstablecimientoVisanetService {
	
	Page<EstablecimientoVisanet> buscarPorCriterios(CriterioBusquedaEstablecimientoVisanet criterioPaginacion, int pageNo, int pageSize);
	
	List<EstablecimientoVisanetComis> buscarComisionesPorSecuencia(CriterioBusquedaEstablecimientoVisanet criterio);
	
}
