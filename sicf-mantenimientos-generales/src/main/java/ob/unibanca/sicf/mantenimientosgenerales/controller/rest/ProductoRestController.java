package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.Producto;
import ob.unibanca.sicf.mantenimientosgenerales.service.producto.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class ProductoRestController {

    private final IProductoService productoService;

    public ProductoRestController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PreAuthorize("hasPermission('MANT_PRODUCTO', '2')")
    @GetMapping(value = "/productos")
    public List<Producto> buscarTodosProductos() {
        return this.productoService.buscarTodosProductos();
    }

    @PreAuthorize("hasPermission('MANT_PRODUCTO', '1')")
    @PostMapping(value = "/productos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Producto registrarProducto(@Validated({IRegistro.class, Default.class}) @RequestBody Producto producto) {
        return this.productoService.registrarProducto(producto);
    }

    @PreAuthorize("hasPermission('MANT_PRODUCTO', '3')")
    @PutMapping(value = "/productos/{idProducto}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Producto actualizarProducto(@IdNumerico(maxRange = 99) @PathVariable int idProducto,
                                 @Validated @RequestBody Producto producto) {
        return this.productoService.actualizarProducto(idProducto, producto);
    }

    @PreAuthorize("hasPermission('MANT_PRODUCTO', '4')")
    @DeleteMapping(value = "/productos/{idProducto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarProducto(@IdNumerico(maxRange = 99) @PathVariable int idProducto) {
        this.productoService.eliminarProducto(idProducto);
    }
}
