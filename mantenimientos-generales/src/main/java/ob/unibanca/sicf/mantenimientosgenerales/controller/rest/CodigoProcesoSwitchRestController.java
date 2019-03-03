package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;
import ob.unibanca.sicf.mantenimientosgenerales.service.codigoprocesoswitch.ICodigoProcesoSwitchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class CodigoProcesoSwitchRestController {

    private final ICodigoProcesoSwitchService codigoProcesoSwitchService;

    public CodigoProcesoSwitchRestController(ICodigoProcesoSwitchService codigoProcesoSwitchService) {
        this.codigoProcesoSwitchService = codigoProcesoSwitchService;
    }

    @GetMapping(value = "/codigoProcesoSwitches")
    public List<CodigoProcesoSwitch> buscarTodosCodigoProcesoSwitches() {
        return this.codigoProcesoSwitchService.buscarTodosCodigoProcesoSwitches();
    }

    @PostMapping(value = "/codigoProcesoSwitches", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CodigoProcesoSwitch registrarCodigoProcesoSwitch(
            @Validated({IRegistro.class, Default.class}) @RequestBody CodigoProcesoSwitch codigoProcesoSwitch) {
        return this.codigoProcesoSwitchService.registrarCodigoProcesoSwitch(codigoProcesoSwitch);
    }

    @PutMapping(value = "/codigoProcesoSwitches/{idCodigoProcesoSwitch}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CodigoProcesoSwitch actualizarCodigoProcesoSwitch(
            @IdCadena(minLength = 6, maxLength = 2, regexpPattern = "[0-9]+") @PathVariable String idCodigoProcesoSwitch,
            @Validated @RequestBody CodigoProcesoSwitch codigoProcesoSwitch) {
        return this.codigoProcesoSwitchService.actualizarCodigoProcesoSwitch(idCodigoProcesoSwitch, codigoProcesoSwitch);
    }

    @DeleteMapping("/codigoProcesoSwitches/{idCodigoProcesoSwitch}")
    public void eliminarCodigoProcesoSwitch(
            @IdCadena(minLength = 6, maxLength = 2, regexpPattern = "[0-9]+") @PathVariable String idCodigoProcesoSwitch) {
        this.codigoProcesoSwitchService.eliminarCodigoProcesoSwitch(idCodigoProcesoSwitch);
    }

}
