package ob.unibanca.sicf.generadorconsultas.service.tabla;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ITablaMapper;
import ob.unibanca.sicf.generadorconsultas.model.Tabla;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTabla;


@Service
public class TablaService extends MantenibleService<Tabla> implements ITablaService {
	
	private final ITablaMapper TablaMapper;
	public TablaService(@Qualifier("ITablaMapper") IMantenibleMapper<Tabla> mantenibleMapper) {
		super(mantenibleMapper);
		this.TablaMapper = (ITablaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Tabla> buscarTodosTabla() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Tabla> buscarPorCriteriosTabla(CriterioBusquedaTabla criterio) {
		return this.TablaMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Tabla registrarTabla(Tabla Tabla) {
		this.registrar(Tabla);
		return Tabla;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Tabla actualizarTabla(int idTabla, Tabla Tabla) {
		Tabla.setIdTabla(idTabla);
		this.actualizar(Tabla);
		return Tabla;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTabla(int idTabla) {
		Tabla parametroRep = Tabla.builder().idTabla(idTabla).build();
		this.eliminar(parametroRep);
	}

	@Override
	public List<Tabla> buscarPermitidosTabla() {
		CriterioBusquedaTabla criterio = new CriterioBusquedaTabla();
		criterio.setUsuario(UsuarioUtil.obtenerUsername());
		List<Tabla> result=this.TablaMapper.buscarPorCriterios(criterio);
		System.out.println(criterio);
		System.out.println(result);
		return result;
	}
}

