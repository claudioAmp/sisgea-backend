package ob.unibanca.sicf.reportes.service.operador;

import ob.unibanca.sicf.reportes.model.Operador;
import java.util.List;

public interface IOperadorService {
	
	public List<Operador> buscarOperadorPorTipoDato(String tipoDato);
	
}
