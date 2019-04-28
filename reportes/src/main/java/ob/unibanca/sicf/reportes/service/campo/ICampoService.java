package ob.unibanca.sicf.reportes.service.campo;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.reportes.model.Campo;

public interface ICampoService extends IMantenibleService<Campo> {
	
	List<Campo> buscarTodosCampos();
	
	
}
