package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.service.codigorazoncobrovisa.ICodigoRazonCobroVisaService;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.mantenimientosgenerales.model.CodigoRazonCobroVisa;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class CodigoRazonCobroVisaRestController {

    private final ICodigoRazonCobroVisaService codigoRazonCobroVisaService;

    public CodigoRazonCobroVisaRestController(ICodigoRazonCobroVisaService codigoRazonCobroVisaService) {
        this.codigoRazonCobroVisaService = codigoRazonCobroVisaService;
    }

    @PreAuthorize("hasPermission('MANT_CODRAZ_VISA', '2')")
    @GetMapping("/codigos-razon")
    public List<CodigoRazonCobroVisa> buscarTodosCodigosRazonCobroVisa() {
        return this.codigoRazonCobroVisaService.buscarTodosCodigosRazonCobroVisa();
    }

    @PreAuthorize("hasPermission('MANT_CODRAZ_VISA', '1')")
    @PostMapping(value = "/codigos-razon", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CodigoRazonCobroVisa registrarCodigoRazonCobroVisa(@Validated({IRegistro.class, Default.class}) @RequestBody CodigoRazonCobroVisa codigoRazonCobroVisa) {
        return this.codigoRazonCobroVisaService.registrarCodigoRazonCobroVisa(codigoRazonCobroVisa);
    }

    @PreAuthorize("hasPermission('MANT_CODRAZ_VISA', '3')")
    @PutMapping(value = "/codigos-razon/{idCodigoRazon}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CodigoRazonCobroVisa actualizarCodigoRazonCobroVisa(@PathVariable("idCodigoRazon") String idCodigoRazon,
                                                       @Validated({IRegistro.class, Default.class}) @RequestBody CodigoRazonCobroVisa codigoRazonCobroVisa) {
        return this.codigoRazonCobroVisaService.actualizarCodigoRazonCobroVisa(idCodigoRazon, codigoRazonCobroVisa);
    }

    @PreAuthorize("hasPermission('MANT_CODRAZ_VISA', '4')")
    @DeleteMapping("/codigos-razon/{idCodigoRazon}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarCodigoRazonCobroVisa(@PathVariable("idCodigoRazon") String idCodigoRazon) {
        this.codigoRazonCobroVisaService.eliminarCodigoRazonCobroVisa(idCodigoRazon);
    }
}
