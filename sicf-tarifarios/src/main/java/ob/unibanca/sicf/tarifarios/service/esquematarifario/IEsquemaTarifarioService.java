package ob.unibanca.sicf.tarifarios.service.esquematarifario;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.tarifarios.model.EsquemaTarifario;

public interface IEsquemaTarifarioService extends IMantenibleService<EsquemaTarifario>{
	
	List<EsquemaTarifario> buscarTodosEsquemas();
	
	EsquemaTarifario buscarEsquemaTarifario(int idEsquema);
	
	EsquemaTarifario registrarEsquema(EsquemaTarifario esquemaTarifario);
	
	EsquemaTarifario actualizarEsquema(int idEsquema, EsquemaTarifario esquemaTarifario);
	
	void eliminarEsquema(int idEsquema);

}
