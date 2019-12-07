package ob.unibanca.sicf.consultasgenerales.mapper;



import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC10TCR0;


@Mapper
public interface IOutgoingVisaTC10Mapper {
	Page<OutgoingVisaTC10TCR0> buscarPorCriteriosTCR0(CriterioBusquedaOutgoingVisaTC10 criterioPaginacion);
	
	
}
