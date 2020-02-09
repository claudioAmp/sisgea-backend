package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.List;

import edu.taller.sisgea.consultasgenerales.model.criterio.establecimientovisanet.CriterioBusquedaEstablecimientoVisanet;
import edu.taller.sisgea.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanet;
import edu.taller.sisgea.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanetComis;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanet;
import edu.taller.sisgea.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanetComis;
import edu.taller.sisgea.consultasgenerales.model.criterio.establecimientovisanet.CriterioBusquedaEstablecimientoVisanet;

@Mapper
public interface IEstablecimientoVisanetMapper {
		
	Page<EstablecimientoVisanet> buscarPorCriterios(CriterioBusquedaEstablecimientoVisanet criterioPaginacion);
	
	List<EstablecimientoVisanetComis> buscarComisionesPorSecuencia(CriterioBusquedaEstablecimientoVisanet criterio);
	
}
