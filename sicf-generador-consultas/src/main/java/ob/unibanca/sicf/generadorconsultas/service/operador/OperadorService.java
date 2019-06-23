package ob.unibanca.sicf.generadorconsultas.service.operador;


import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.unibanca.sicf.generadorconsultas.mapper.IOperadorMapper;
import ob.unibanca.sicf.generadorconsultas.model.Operador;

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
