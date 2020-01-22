package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaTC10;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisatc10.IDistribucionVisaTC10Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class DistribucionVisaTC10RestController {

    private final IDistribucionVisaTC10Service distribucionService;

    public DistribucionVisaTC10RestController(IDistribucionVisaTC10Service distribucionService) {
        this.distribucionService = distribucionService;
    }

    @PreAuthorize("hasPermission('MANT_DIST_VISA_TC10', '2')")
    @GetMapping("/distribucionVisaTC10")
    public List<DistribucionVisaTC10> buscarTodosDistribucionVisaTC10() {
        return this.distribucionService.buscarRegistrosDistribucionVisaTC10();
    }

    @PreAuthorize("hasPermission('MANT_DIST_VISA_TC10', '3')")
    @PutMapping("/distribucionVisaTC10/{secuenciaAgrupada}")
    public DistribucionVisaTC10 actualizarDistribucionVisaTC10(
            @PathVariable String secuenciaAgrupada,
            @Validated @RequestBody DistribucionVisaTC10 DistribucionVisaTC10) {
        return this.distribucionService.actualizarDistribucionVisaTC10(secuenciaAgrupada, DistribucionVisaTC10);
    }
}
