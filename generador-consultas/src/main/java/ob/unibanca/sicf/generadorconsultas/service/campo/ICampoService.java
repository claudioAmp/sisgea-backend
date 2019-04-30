package ob.unibanca.sicf.generadorconsultas.service.campo;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Campo;


public interface ICampoService extends IMantenibleService<Campo> {
	
	List<Campo> buscarTodosCampos();
	
	
}
