package ob.unibanca.sicf.facturacion.mapper.base;

import ob.unibanca.sicf.facturacion.model.base.ParametroMantenimiento;

import java.util.List;

public interface IMantenibleMapper<T> {
	
	void mantener(ParametroMantenimiento parametroMantenimiento);
	
	List<T> buscarTodos();
}
