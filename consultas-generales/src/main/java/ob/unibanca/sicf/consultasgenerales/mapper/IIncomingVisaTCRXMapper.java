package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import ob.unibanca.sicf.consultasgenerales.model.IncomingVisaTCR0;

@Mapper
public interface IIncomingVisaTCRXMapper {
	
	public List<IncomingVisaTCR0> buscarTodosTCR0();
	
	Optional<IncomingVisaTCR0> buscarTCR1(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR0> buscarTCR3(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR0> buscarTCR4(int idSecuenciaIncoming);
	
	Optional<IncomingVisaTCR0> buscarTCR5(int idSecuenciaIncoming);

}
