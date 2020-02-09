package edu.taller.sisgea.tarifarios.service.esquematarifario;

import java.util.List;

import edu.taller.sisgea.tarifarios.model.EsquemaTarifario;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface IEsquemaTarifarioService extends IMantenibleService<EsquemaTarifario>{
	
	List<EsquemaTarifario> buscarTodosEsquemas();
	
	EsquemaTarifario buscarEsquemaTarifario(int idEsquema);
	
	EsquemaTarifario registrarEsquema(EsquemaTarifario esquemaTarifario);
	
	EsquemaTarifario actualizarEsquema(int idEsquema, EsquemaTarifario esquemaTarifario);
	
	void eliminarEsquema(int idEsquema);

}
