package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionMcEventos;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucionmceventos.IDistribucionMcEventosService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class DistribucionMcEventosRestController {

    private final IDistribucionMcEventosService distribucionService;

    public DistribucionMcEventosRestController(IDistribucionMcEventosService distribucionService) {
        this.distribucionService = distribucionService;
    }

    @PreAuthorize("hasPermission('MANT_DIST_EVENTO_MC', '2')")
    @GetMapping("/distribucionMcEventos")
    public List<DistribucionMcEventos> buscarTodosDistribucionMcEventos() {
        return this.distribucionService.buscarRegistrosDistribucionEventosMc();
    }

    @PreAuthorize("hasPermission('MANT_DIST_EVENTO_MC', '3')")
    @PutMapping("/distribucionMcEventos/{secuenciaAgrupada}")
    public DistribucionMcEventos actualizarDistribucionMcEventos(
            @PathVariable String secuenciaAgrupada,
            @Validated @RequestBody DistribucionMcEventos distribucionMcEventos) {
        return this.distribucionService.actualizarDistribucionMcEventos(secuenciaAgrupada, distribucionMcEventos);
    }
}
