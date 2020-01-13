package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanet;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanetComis;
import ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientovisanet.CriterioBusquedaEstablecimientoVisanet;

@Mapper
public interface IEstablecimientoVisanetMapper {
		
	Page<EstablecimientoVisanet> buscarPorCriterios(CriterioBusquedaEstablecimientoVisanet criterioPaginacion);
	
	List<EstablecimientoVisanetComis> buscarComisionesPorSecuencia(CriterioBusquedaEstablecimientoVisanet criterio);
	
}
