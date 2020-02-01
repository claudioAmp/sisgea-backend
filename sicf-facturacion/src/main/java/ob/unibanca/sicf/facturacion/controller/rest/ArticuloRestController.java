package ob.unibanca.sicf.facturacion.controller.rest;


import ob.unibanca.sicf.facturacion.model.Articulo;
import ob.unibanca.sicf.facturacion.service.articulo.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ArticuloRestController{


    @Autowired
    public IArticuloService iArticuloService;

    @PreAuthorize("hasPermission('MANT_ARTICULO','2')")
    @GetMapping("/articulo")
    public List<Articulo> obtenerTotalArticulos(){

        return this.iArticuloService.buscarTodosArticulos();
    }

    @PreAuthorize("hasPermission('MANT_ARTICULO','1')")
    @PostMapping(value = "/articulo" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Articulo crearArticulo (@RequestBody Articulo articulo){

        return this.iArticuloService.registrarArticulo(articulo);
    }

    @PreAuthorize("hasPermission('MANT_ARTICULO','3')")
    @PutMapping(value = "/articulo/{idArticulo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Articulo actualizarArticulo (@PathVariable String idArticulo,
                                   @Validated @RequestBody Articulo articulo){

        return this.iArticuloService.actualizarArticulo(idArticulo, articulo);
    }

    @PreAuthorize("hasPermission('MANT_ARTICULO','4')")
    @DeleteMapping("/articulo/{idArticulo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void crearArticulo (@PathVariable String idArticulo){

        this.iArticuloService.eliminarArticulo(idArticulo);
    }
}