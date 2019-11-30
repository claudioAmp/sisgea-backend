package ob.unibanca.sicf.mantenimientosgenerales.service.producto;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Producto;

import java.util.List;
public interface IProductoService extends IMantenibleService<Producto> {

    List<Producto> buscarTodosProductos();

    Producto registrarProducto(Producto producto);

    Producto actualizarProducto(int idProducto, Producto producto);

    void eliminarProducto(int idProducto);
}
