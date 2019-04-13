package ob.unibanca.sicf.consultasgenerales.service.incomingvisa;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaTCRXMapper;
import ob.unibanca.sicf.consultasgenerales.model.IncomingVisaTCR0;

@Service
public class IncomingVisaTCRXService implements IIncomingVisaTCRXService{
	
	IIncomingVisaTCRXMapper incomingVisaTCR0;
	
	public IncomingVisaTCRXService(IIncomingVisaTCRXMapper incomingVisaTCR0) {
		this.incomingVisaTCR0 = incomingVisaTCR0;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<IncomingVisaTCR0> buscarTodosIncomingVisaTCR0() {
		return incomingVisaTCR0.buscarTodosTCR0();
	}
}
