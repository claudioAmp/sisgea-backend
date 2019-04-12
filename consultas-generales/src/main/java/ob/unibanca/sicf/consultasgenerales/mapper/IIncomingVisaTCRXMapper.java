package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import ob.unibanca.sicf.consultasgenerales.model.IncomingVisaTCR0;

@Mapper
public interface IIncomingVisaTCRXMapper {
	
	public List<IncomingVisaTCR0> buscarTodosTCR0();

}
