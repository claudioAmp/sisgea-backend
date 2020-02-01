package ob.unibanca.sicf.facturacion.service.articulo;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.Articulo;

import java.util.List;

public interface IArticuloService extends IMantenibleService<Articulo> {

    List<Articulo>  buscarTodosArticulos();

    Articulo registrarArticulo(Articulo articulo);

    Articulo actualizarArticulo(String idArticulo, Articulo articulo);

    void eliminarArticulo(String idArticulo);
}