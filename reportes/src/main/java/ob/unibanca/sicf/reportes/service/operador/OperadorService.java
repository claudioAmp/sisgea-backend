package ob.unibanca.sicf.reportes.service.operador;

import ob.unibanca.sicf.reportes.model.Operador;
import org.springframework.stereotype.Service;
import ob.unibanca.sicf.reportes.mapper.IOperadorMapper;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class OperadorService implements IOperadorService {
	
	private final IOperadorMapper operadorMapper;
	
	public OperadorService(@Qualifier("IOperadorMapper") IOperadorMapper operadorMapper) {
		this.operadorMapper = operadorMapper;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Operador> buscarOperadorPorTipoDato(String tipoDato){
		return operadorMapper.buscarOperadorPorTipoDato(tipoDato);
	}
	
}
