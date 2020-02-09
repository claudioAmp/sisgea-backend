package edu.taller.sisgea.mantenimientosgenerales.service.producto;

import edu.taller.sisgea.mantenimientosgenerales.model.Producto;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;
public interface IProductoService extends IMantenibleService<Producto> {

    List<Producto> buscarTodosProductos();

    Producto registrarProducto(Producto producto);

    Producto actualizarProducto(int idProducto, Producto producto);

    void eliminarProducto(int idProducto);
}
