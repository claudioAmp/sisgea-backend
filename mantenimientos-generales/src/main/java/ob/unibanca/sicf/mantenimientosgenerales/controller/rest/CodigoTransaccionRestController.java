package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.codigotransaccion.ICodigoTransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class CodigoTransaccionRestController {

    private final ICodigoTransaccionService codigoTransaccionService;

    public CodigoTransaccionRestController(ICodigoTransaccionService codigoTransaccionService) {
        this.codigoTransaccionService = codigoTransaccionService;
    }

    @GetMapping(value = "/codigoTransacciones")
    public List<CodigoTransaccion> buscarTodosCodigoTransacciones() {
        return this.codigoTransaccionService.buscarTodosCodigoTransacciones();
    }

    @PostMapping(value = "/codigoTransacciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CodigoTransaccion registrarCodigoTransaccion(
            @Validated({IRegistro.class, Default.class}) @RequestBody CodigoTransaccion codigoTransaccion) {
        return this.codigoTransaccionService.registrarCodigoTransaccion(codigoTransaccion);
    }

    @PutMapping(value = "/codigoTransacciones/{idClaseTransaccion}/{idCodigoTransaccion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CodigoTransaccion actualizarCodigoTransaccion(
            @IdNumerico(maxRange = 9999) @PathVariable int idClaseTransaccion,
            @IdNumerico(maxRange = 9999) @PathVariable int idCodigoTransaccion,
            @Validated @RequestBody CodigoTransaccion codigoTransaccion) {
        return this.codigoTransaccionService.actualizarCodigoTransaccion(idClaseTransaccion, idCodigoTransaccion, codigoTransaccion);
    }

    @DeleteMapping(value = "/instituciones/{idClaseTransaccion}/{idCodigoTransaccion}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarCodigoTransaccion(
            @IdNumerico(maxRange = 9999) @PathVariable int idClaseTransaccion,
            @IdNumerico(maxRange = 9999) @PathVariable int idCodigoTransaccion) {
        this.codigoTransaccionService.eliminarCodigoTransaccion(idClaseTransaccion, idCodigoTransaccion);
    }
}
