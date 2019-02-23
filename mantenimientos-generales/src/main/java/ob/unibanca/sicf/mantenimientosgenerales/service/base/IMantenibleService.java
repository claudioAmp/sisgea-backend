package ob.unibanca.sicf.mantenimientosgenerales.service.base;

import java.util.List;

public interface IMantenibleService<T> {
	
	List<T> buscarTodos();
	
	void registrar(T objetoMantenido);
	
	void actualizar(T objetoMantenido);
	
	void eliminar(T objetoMantenido);
}
