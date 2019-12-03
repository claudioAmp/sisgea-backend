package ob.unibanca.sicf.tarifarios.controller.rest;

import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.TarifarioMiembro;
import ob.unibanca.sicf.tarifarios.service.tarifariomiembro.ITarifarioMiembroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class TarifarioMiembroRestController {
	
	private final ITarifarioMiembroService tarifarioMiembroService;

    public TarifarioMiembroRestController(ITarifarioMiembroService tarifarioMiembroService) {
        this.tarifarioMiembroService = tarifarioMiembroService;
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_MIEMBRO', '2')")
    @GetMapping("/tarifarios-miembros")
    public List<TarifarioMiembro> buscarTodosTarifarioMiembro() {
        return this.tarifarioMiembroService.buscarTodosTarifariosMiembros();
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_MIEMBRO', '1')")
    @PostMapping(value = "/tarifarios-miembros", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public TarifarioMiembro registrarTarifarioMiembro(@Validated({IRegistro.class, Default.class}) @RequestBody TarifarioMiembro tarifarioMiembro) {
        return this.tarifarioMiembroService.registrarTarifarioMiembro(tarifarioMiembro);
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_MIEMBRO', '3')")
    @PutMapping(value = "/tarifarios-miembros/{idTarifarioMiembro}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TarifarioMiembro actualizarTarifarioMiembro(@PathVariable("idTarifarioMiembro") Integer idTarifarioMiembro,
        @Validated({IRegistro.class, Default.class}) @RequestBody TarifarioMiembro tarifarioMiembro) {
        return this.tarifarioMiembroService.actualizarTarifarioMiembro(idTarifarioMiembro, tarifarioMiembro);
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_MIEMBRO', '4')")
    @DeleteMapping("/tarifarios-miembros/{idTarifarioMiembro}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarTarifarioMiembro(@PathVariable("idTarifarioMiembro") Integer idTarifarioMiembro) {
        this.tarifarioMiembroService.eliminarTarifarioMiembro(idTarifarioMiembro);
    }


}
