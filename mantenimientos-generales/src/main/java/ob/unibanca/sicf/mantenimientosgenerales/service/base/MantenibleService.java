package ob.unibanca.sicf.mantenimientosgenerales.service.base;

import ob.unibanca.sicf.mantenimientosgenerales.mapper.base.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.base.ParametroMantenimiento;
import ob.unibanca.sicf.mantenimientosgenerales.service.enumeracion.Modo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MantenibleService<T> implements IMantenibleService<T> {
	
	private static final String USUARIO_DUMMY = "Usuario Dummy";
	private IMantenibleMapper<T> mantenibleMapper;
	
	public MantenibleService() {
	}
	
	public MantenibleService(IMantenibleMapper<T> mantenibleMapper) {
		this.mantenibleMapper = mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public List<T> buscarTodos() {
		return this.mantenibleMapper.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void registrar(T objetoMantenido) {
		this.mantenibleMapper.mantener(
				new ParametroMantenimiento(Modo.INSERT.getValor(), objetoMantenido, USUARIO_DUMMY));
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void actualizar(T objetoMantenido) {
		this.mantenibleMapper.mantener(
				new ParametroMantenimiento(Modo.UPDATE.getValor(), objetoMantenido, USUARIO_DUMMY));
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void eliminar(T objetoMantenido) {
		this.mantenibleMapper.mantener(
				new ParametroMantenimiento(Modo.DELETE.getValor(), objetoMantenido, USUARIO_DUMMY));
	}
}
