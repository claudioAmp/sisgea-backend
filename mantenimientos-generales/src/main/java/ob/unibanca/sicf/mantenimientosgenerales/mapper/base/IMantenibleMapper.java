package ob.unibanca.sicf.mantenimientosgenerales.mapper.base;

import ob.unibanca.sicf.mantenimientosgenerales.model.base.ParametroMantenimiento;

import java.util.List;

public interface IMantenibleMapper<T> {
	
	void mantener(ParametroMantenimiento parametroMantenimiento);
	
	List<T> buscarTodos();
}
