package edu.taller.sisgea.generadorconsultas.service.operador;


import edu.taller.sisgea.generadorconsultas.mapper.IOperadorMapper;
import edu.taller.sisgea.generadorconsultas.model.Operador;
import org.springframework.stereotype.Service;
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
