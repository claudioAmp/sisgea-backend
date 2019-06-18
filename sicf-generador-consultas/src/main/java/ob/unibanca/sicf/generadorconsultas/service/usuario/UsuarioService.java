package ob.unibanca.sicf.generadorconsultas.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IUsuarioMapper;
import ob.unibanca.sicf.generadorconsultas.model.Usuario;


@Service
public class UsuarioService extends MantenibleService<Usuario> implements IUsuarioService {
	
	private final IUsuarioMapper UsuarioMapper;
	public UsuarioService(@Qualifier("IUsuarioMapper") IMantenibleMapper<Usuario> mantenibleMapper) {
		super(mantenibleMapper);
		this.UsuarioMapper = (IUsuarioMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Usuario> buscarTodosUsuarios() {
		return this.buscarTodos();
	}
}

