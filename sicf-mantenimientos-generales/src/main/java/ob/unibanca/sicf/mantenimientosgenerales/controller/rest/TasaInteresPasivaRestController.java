package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.TasaInteresPasiva;
import ob.unibanca.sicf.mantenimientosgenerales.service.tasainterespasiva.ITasaInteresPasivaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

@Validated // TODO(validated): que es validated?
@RestController
@RequestMapping(value="/tasas-interes-pasivas")
public class TasaInteresPasivaRestController {

    private final ITasaInteresPasivaService tasaInteresPasivaService;

    public TasaInteresPasivaRestController(ITasaInteresPasivaService tasaInteresPasivaService) {
        this.tasaInteresPasivaService = tasaInteresPasivaService;
    }

    // TODO(1. permisos-controller-tasa): que permisos necesita este mantenimiento?
    @PreAuthorize("hasPermission('MANT_INSTIT', '2')")
    @GetMapping
    public List<TasaInteresPasiva> buscarTodasTasasInteresPasivas() {
        return this.tasaInteresPasivaService.buscarTodasTasasInteresPasivas();
    }

    // TODO(2. permisos-controller-tasa): que permisos necesita este mantenimiento?
    @PreAuthorize("hasPermission('MANT_INSTIT', '2')")
    @GetMapping(value = "/{fecha-proceso}")
    public TasaInteresPasiva buscarTasaInteresPasiva(@PathVariable("fecha-proceso") Date fechaProceso) {
        return this.tasaInteresPasivaService.buscarTasaInteresPasiva(fechaProceso);
    }

    // TODO(3. permisos-controller-tasa): que permisos necesita este mantenimiento?
    @PreAuthorize("hasPermission('MANT_SERVIC', '1')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public TasaInteresPasiva registrarTasaInteresPasiva(@Validated({IRegistro.class, Default.class}) @RequestBody TasaInteresPasiva tasaInteresPasiva) {
        return this.tasaInteresPasivaService.registrarTasaInteresPasiva(tasaInteresPasiva);
    }

    // TODO(4. permisos-controller-tasa): que permisos necesita este mantenimiento?
    @PreAuthorize("hasPermission('MANT_SERVIC', '3')")
    @PutMapping(value = "/{fecha-proceso}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TasaInteresPasiva actualizarTasaInteresPasiva(@PathVariable("fecha-proceso") Date fechaProceso,
        @Validated({IRegistro.class, Default.class}) @RequestBody TasaInteresPasiva tasaInteresPasiva) {
        return this.tasaInteresPasivaService.actualizarTasaInteresPasiva(fechaProceso, tasaInteresPasiva);
    }

    // TODO(5. permisos-controller-tasa): que permisos necesita este mantenimiento?
    @PreAuthorize("hasPermission('MANT_SERVIC', '4')")
    @DeleteMapping("/{fecha-proceso}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarTasaInteresPasiva(@PathVariable("fecha-proceso") Date fechaProceso) {
        this.tasaInteresPasivaService.eliminarTasaInteresPasiva(fechaProceso);
    }
}
