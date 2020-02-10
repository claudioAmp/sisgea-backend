package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.model.ParametrosGenerales;
import edu.taller.sisgea.mantenimientosgenerales.service.parametrosgenerales.IParametrosGeneralesService;
import edu.taller.sisgea.mantenimientosgenerales.service.parametrosistema.IParametroSistemaService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class ParametrosGeneralesRestController {

    private IParametrosGeneralesService parametrosGeneralesService;

    public ParametrosGeneralesRestController(IParametrosGeneralesService parametrosGeneralesService) {
        this.parametrosGeneralesService = parametrosGeneralesService;
    }

    //@PreAuthorize("hasPermission('MANT_PARSIS', '2')")
    @GetMapping("/mantenimientos-generales")
    public List<ParametrosGenerales> buscarTodosParametrosSistema() {
        return this.parametrosGeneralesService.buscarTodosParametrosGenerales();
    }

    //@PreAuthorize("hasPermission('MANT_PARSIS', '3')")
    @PutMapping(value = "/mantenimientos-generales", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ParametrosGenerales actualizarParametrosGenerales(@Validated @RequestBody ParametrosGenerales parametrosGenerales) {
        return this.parametrosGeneralesService.actualizarParametrosGenerales(parametrosGenerales);
    }

}
