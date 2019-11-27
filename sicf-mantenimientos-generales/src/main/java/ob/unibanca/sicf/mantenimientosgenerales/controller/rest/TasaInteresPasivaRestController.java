package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.TasaInteresPasiva;
import ob.unibanca.sicf.mantenimientosgenerales.service.tasainterespasiva.ITasaInteresPasivaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequestMapping(value="/tasas-interes-pasivas")
public class TasaInteresPasivaRestController {

    private final ITasaInteresPasivaService tasaInteresPasivaService;

    public TasaInteresPasivaRestController(ITasaInteresPasivaService tasaInteresPasivaService) {
        this.tasaInteresPasivaService = tasaInteresPasivaService;
    }

    @PreAuthorize("hasPermission('MANT_TASA_INTERES_PASIVA', '2')")
    @GetMapping
    public List<TasaInteresPasiva> buscarTodasTasasInteresPasivas() {
        return this.tasaInteresPasivaService.buscarTodasTasasInteresPasivas();
    }

    @PreAuthorize("hasPermission('MANT_TASA_INTERES_PASIVA', '2')")
    @GetMapping(value = "/{fecha-proceso}")
    public TasaInteresPasiva buscarTasaInteresPasiva(@PathVariable("fecha-proceso")
         @DateTimeFormat(pattern = "yyyy-MM-dd")Date fechaProceso) {
        return this.tasaInteresPasivaService.buscarTasaInteresPasiva(fechaProceso);
    }

    @PreAuthorize("hasPermission('MANT_TASA_INTERES_PASIVA', '1')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public TasaInteresPasiva registrarTasaInteresPasiva(@Validated({IRegistro.class, Default.class}) @RequestBody TasaInteresPasiva tasaInteresPasiva) {
        return this.tasaInteresPasivaService.registrarTasaInteresPasiva(tasaInteresPasiva);
    }

    @PreAuthorize("hasPermission('MANT_TASA_INTERES_PASIVA', '3')")
    @PutMapping(value = "/{fecha-proceso}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TasaInteresPasiva actualizarTasaInteresPasiva(@PathVariable("fecha-proceso") Date fechaProceso,
        @Validated({IRegistro.class, Default.class}) @RequestBody TasaInteresPasiva tasaInteresPasiva) {
        return this.tasaInteresPasivaService.actualizarTasaInteresPasiva(fechaProceso, tasaInteresPasiva);
    }

    @PreAuthorize("hasPermission('MANT_TASA_INTERES_PASIVA', '4')")
    @DeleteMapping("/{fecha-proceso}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarTasaInteresPasiva(@PathVariable("fecha-proceso") Date fechaProceso) {
        this.tasaInteresPasivaService.eliminarTasaInteresPasiva(fechaProceso);
    }
}
