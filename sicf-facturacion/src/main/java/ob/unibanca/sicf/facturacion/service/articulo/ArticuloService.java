package ob.unibanca.sicf.facturacion.service.articulo;


import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.facturacion.model.Articulo;
import ob.unibanca.sicf.facturacion.model.Detraccion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticuloService extends MantenibleService<Articulo> implements IArticuloService{

    public ArticuloService(@Qualifier("IArticuloMapper") IMantenibleMapper<Articulo> mantenibleMapper) {
        super(mantenibleMapper);
    }

    @Override
    @Transactional
    public List<Articulo> buscarTodosArticulos() {
        return this.buscarTodos();
    }

    @Override
    @Transactional
    public Articulo registrarArticulo(Articulo articulo) {
        this.registrar(articulo);
        return articulo;
    }

    @Override
    public Articulo actualizarArticulo(String idArticulo, Articulo articulo) {

        articulo.setIdArticulo(idArticulo);
        this.actualizar(articulo);
        return articulo;
    }

    @Override
    public void eliminarArticulo(String idArticulo) {
        Articulo articulo = Articulo.builder().idArticulo(idArticulo).build();

        this.eliminar(articulo);
    }
}