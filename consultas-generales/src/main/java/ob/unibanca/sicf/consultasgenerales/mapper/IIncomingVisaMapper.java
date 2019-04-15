package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR5;


@Mapper
public interface IIncomingVisaMapper {
	
	public Page<IncomingVisaTCR0> buscarPorCriteriosTCR0(
			CriterioBusquedaIncomingVisaTCR0 criterioPaginacion);
	
	Optional<IncomingVisaTCR1> buscarPorIdSecuenciaTCR1(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR3> buscarPorIdSecuenciaTCR3(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR4> buscarPorIdSecuenciaTCR4(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR5> buscarPorIdSecuenciaTCR5(int idSecuenciaIncoming);

}
