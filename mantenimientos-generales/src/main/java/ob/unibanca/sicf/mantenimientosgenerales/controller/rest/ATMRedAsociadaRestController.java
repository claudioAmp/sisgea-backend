package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedAsociada;
import ob.unibanca.sicf.mantenimientosgenerales.service.atmredasociada.IATMRedAsociadaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class ATMRedAsociadaRestController {

    private final IATMRedAsociadaService atmRedAsociadaService;

    public ATMRedAsociadaRestController(IATMRedAsociadaService atmRedAsociadaService) {
        this.atmRedAsociadaService = atmRedAsociadaService;
    }

    @GetMapping("/atms-redes-asociadas")
    public List<ATMRedAsociada> buscarTodosATMsRedAsociada() {
        return this.atmRedAsociadaService.buscarTodosATMsRedAsociada();
    }

    @GetMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<ATMRedAsociada> buscarATMsRedAsociadaInstitucion(
            @IdNumerico(maxRange = 9999) @PathVariable int idInstitucion) {
        return this.atmRedAsociadaService.buscarATMsRedAsociadaInstitucion(idInstitucion);
    }

    @PostMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ATMRedAsociada registrarATMRedAsociada(
            @IdNumerico(maxRange = 9999) @PathVariable int idInstitucion,
            @Validated({IRegistro.class, Default.class}) @RequestBody ATMRedAsociada atmRedAsociada) {
        return this.atmRedAsociadaService.registrarATMRedAsociada(idInstitucion, atmRedAsociada);
    }

    @PutMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas/{idATM}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ATMRedAsociada actualizarATMRedAsociada(
            @IdNumerico(maxRange = 9999) @PathVariable int idInstitucion,
            @IdNumerico(maxRange = 9999) @PathVariable int idATM,
            @Validated({IRegistro.class, Default.class}) @RequestBody ATMRedAsociada atmRedAsociada) {
        return this.atmRedAsociadaService.actualizarATMRedAsociada(idATM, idInstitucion, atmRedAsociada);
    }

    @DeleteMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas/{idATM}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarATMRedAsociada(
            @IdNumerico(maxRange = 9999) @PathVariable int idInstitucion,
            @IdNumerico(maxRange = 9999) @PathVariable int idATM) {
        this.atmRedAsociadaService.eliminarATMRedAsociada(idATM, idInstitucion);
    }

}
