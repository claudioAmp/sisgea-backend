package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;


@Mapper
public interface IIncomingVisaMapper {
	
	public Page<IncomingVisaTCR0> buscarPorCriterios(
			CriterioBusquedaIncomingVisaTCR0 criterioPaginacion);
	
	Optional<IncomingVisaTCR0> buscarTCR1(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR0> buscarTCR3(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR0> buscarTCR4(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR0> buscarTCR5(int idSecuenciaIncoming);

}
