package ob.unibanca.sicf.generadorconsultas.service.operador;

import java.util.List;

import ob.unibanca.sicf.generadorconsultas.model.Operador;

public interface IOperadorService {
	
	public List<Operador> buscarOperadorPorTipoDato(String tipoDato);
	
}
