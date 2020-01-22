package ob.unibanca.sicf.consultasgenerales.service.establecimientovisanet;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IEstablecimientoVisanetMapper;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanet;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanetComis;
import ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientovisanet.CriterioBusquedaEstablecimientoVisanet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstablecimientoVisanetService implements  IEstablecimientoVisanetService{
	
	private final IEstablecimientoVisanetMapper establecimientoVisanetMapper;
	
	public EstablecimientoVisanetService(IEstablecimientoVisanetMapper establecimientoVisanetMapper) {
		this.establecimientoVisanetMapper = establecimientoVisanetMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<EstablecimientoVisanet> buscarPorCriterios(CriterioBusquedaEstablecimientoVisanet criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return establecimientoVisanetMapper.buscarPorCriterios(criterioPaginacion);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EstablecimientoVisanetComis> buscarComisionesPorSecuencia(CriterioBusquedaEstablecimientoVisanet criterio) {
		return this.establecimientoVisanetMapper.buscarComisionesPorSecuencia(criterio);
	}
	
}
