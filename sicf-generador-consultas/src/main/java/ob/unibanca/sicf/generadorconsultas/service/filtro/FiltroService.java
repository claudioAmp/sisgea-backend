package ob.unibanca.sicf.generadorconsultas.service.filtro;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IFiltroMapper;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaFiltro;

@Service
public class FiltroService extends MantenibleService<Filtro> implements IFiltroService {

	private final IFiltroMapper FiltroMapper;
	public FiltroService(@Qualifier("IFiltroMapper") IMantenibleMapper<Filtro> mantenibleMapper) {
		super(mantenibleMapper);
		this.FiltroMapper = (IFiltroMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Filtro> buscarTodosFiltro() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Filtro> buscarPorCriteriosFiltro(CriterioBusquedaFiltro criterio) {
		if(criterio.getPermited()==1) {
			criterio.setUsuario(UsuarioUtil.obtenerUsername());
		}
		return this.FiltroMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Filtro registrarFiltro(Filtro Filtro) {
		this.registrar(Filtro);
		return Filtro;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Filtro actualizarFiltro(int idFiltroCampo, Filtro filtro) {
		filtro.setIdFiltroCampo(idFiltroCampo);
		this.actualizar(filtro);
		return filtro;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarFiltro(int idFiltroCampo) {
		Filtro filtro = Filtro.builder().idFiltroCampo(idFiltroCampo).build();
		this.eliminar(filtro);
	}

	
}