package ob.unibanca.sicf.generadorconsultas.service.campo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Campo;


@Service
public class CampoService extends MantenibleService<Campo> implements ICampoService {
	
	public CampoService(@Qualifier("ICampoMapper") IMantenibleMapper<Campo> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Campo> buscarTodosCampos() {
		return this.buscarTodos();
	}
	
}

