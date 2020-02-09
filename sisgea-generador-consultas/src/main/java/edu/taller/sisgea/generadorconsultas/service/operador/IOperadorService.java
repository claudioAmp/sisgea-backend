package edu.taller.sisgea.generadorconsultas.service.operador;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Operador;

public interface IOperadorService {
	
	public List<Operador> buscarOperadorPorTipoDato(String tipoDato);
	
}
