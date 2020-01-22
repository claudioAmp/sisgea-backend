package ob.unibanca.sicf.facturacion.service.detraccion;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.Detraccion;

public interface IDetraccionService extends IMantenibleService<Detraccion> {
	List<Detraccion> buscarTodosDetraccion();

	Detraccion registrarDetraccion(Detraccion detraccion);

	Detraccion actualizarDetraccion(int idDetraccion, Detraccion detraccion);

	void eliminarDetraccion(int idDetraccion);
}
