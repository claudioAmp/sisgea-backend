package ob.unibanca.sicf.mantenimientosgenerales.service.producto;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Producto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService extends MantenibleService<Producto> implements IProductoService{

    public ProductoService(@Qualifier("IProductoMapper") IMantenibleMapper<Producto> mantenibleMapper) {
        super(mantenibleMapper);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Producto> buscarTodosProductos() {
        return this.buscarTodos();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Producto registrarProducto(Producto producto) {
        this.registrar(producto);
        return producto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Producto actualizarProducto(int idProducto, Producto producto) {
        producto.setIdProducto(idProducto);
        this.actualizar(producto);
        return producto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarProducto(int idProducto) {
        Producto producto = Producto.builder().idProducto(idProducto).build();
        this.eliminar(producto);
    }
}
