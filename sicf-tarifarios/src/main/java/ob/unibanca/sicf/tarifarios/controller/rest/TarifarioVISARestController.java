/*package ob.unibanca.sicf.tarifarios.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.TarifarioVISA;
import ob.unibanca.sicf.tarifarios.service.tarifarioVISA.ITarifarioVISAService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class TarifarioVISARestController {

    private final ITarifarioVISAService tarifarioVISAService;

    public TarifarioVISARestController(ITarifarioVISAService tarifarioVISAService) {
        this.tarifarioVISAService = tarifarioVISAService;
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_VISA','2')")
    @GetMapping("/tarifarios-visa")
    public List<TarifarioVISA> buscarTodosTarifariosVISA() {
        return this.tarifarioVISAService.buscarTodosTarifariosVISA();
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_VISA','1')")
    @PostMapping(value = "/tarifarios-visa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public TarifarioVISA registrarTarifarioVISA(
            @Validated({IRegistro.class, Default.class}) @RequestBody TarifarioVISA tarifarioVISA) {
        return this.tarifarioVISAService.registrarTarifarioVISA(tarifarioVISA);
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_VISA','3')")
    @PutMapping(value = "/tarifarios-visa/{idTarifarioVISA}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TarifarioVISA actualizarTarifarioVISA(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioVISA,
                                                     @Validated @RequestBody TarifarioVISA tarifarioVISA) {
        return this.tarifarioVISAService.actualizarTarifarioVISA(idTarifarioVISA, tarifarioVISA);
    }

    @PreAuthorize("hasPermission('MANT_TARIFARIO_VISA','4')")
    @DeleteMapping("/tarifarios-visa/{idTarifarioVISA}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarTarifarioVISA(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioVISA) {
        this.tarifarioVISAService.eliminarTarifarioVISA(idTarifarioVISA);
    }

}
*/
