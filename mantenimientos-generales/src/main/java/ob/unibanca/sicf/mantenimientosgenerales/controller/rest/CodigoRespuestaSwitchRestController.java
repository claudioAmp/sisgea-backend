package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoRespuestaSwitch;
import ob.unibanca.sicf.mantenimientosgenerales.service.codigorespuestaswitch.ICodigoRespuestaSwitchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class CodigoRespuestaSwitchRestController {

    private final ICodigoRespuestaSwitchService codigoRespuestaSwitchService;

    public CodigoRespuestaSwitchRestController(ICodigoRespuestaSwitchService codigoRespuestaSwitchService) {
        this.codigoRespuestaSwitchService = codigoRespuestaSwitchService;
    }

    @GetMapping("/codigo-respuesta-switches")
    public List<CodigoRespuestaSwitch> buscarTodosCodigoRespuestaSwitches(){
        return this.codigoRespuestaSwitchService.buscarTodosCodigoRespuetaSwitches();
    }

    @PostMapping(value = "/codigo-respuesta-switches", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CodigoRespuestaSwitch registrarCodigoRespuestaSwitch(
            @Validated({IRegistro.class, Default.class}) @RequestBody CodigoRespuestaSwitch codigoRespuestaSwitch) {
        return this.codigoRespuestaSwitchService.registrarCodigoRespuestaSwitch(codigoRespuestaSwitch);
    }

    @PutMapping(value = "/codigo-respuesta-switches/{idCodigoRespuestaSwitch}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CodigoRespuestaSwitch actualizarCodigoRespuestaSwitch(
            @IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[0-9]+") @PathVariable String idCodigoRespuestaSwitch,
            @Validated @RequestBody CodigoRespuestaSwitch codigoRespuestaSwitch) {
        return this.codigoRespuestaSwitchService.actualizarCodigoRespuestaSwitch(idCodigoRespuestaSwitch, codigoRespuestaSwitch);
    }

    @DeleteMapping("/codigo-respuesta-switches/{idCodigoRespuestaSwitch}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarCodigoRespuestaSwitch(
            @IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[0-9]+") @PathVariable String idCodigoRespuestaSwitch) {
        this.codigoRespuestaSwitchService.eliminarCodigoRespuestaSwitch(idCodigoRespuestaSwitch);
    }

}
