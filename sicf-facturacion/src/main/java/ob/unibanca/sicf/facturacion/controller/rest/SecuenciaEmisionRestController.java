package ob.unibanca.sicf.facturacion.controller.rest;

import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.facturacion.model.SecuenciaEmision;
import ob.unibanca.sicf.facturacion.service.secuenciaemision.ISecuenciaEmisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class SecuenciaEmisionRestController {

    private final ISecuenciaEmisionService secuenciaEmisionService;

    public SecuenciaEmisionRestController(ISecuenciaEmisionService secuenciaEmisionService) {
        this.secuenciaEmisionService = secuenciaEmisionService;
    }

    @PreAuthorize("hasPermission('MANT_SECUENCIA_EMISION', '2')")
    @GetMapping("/secuencias-emisiones")
    public List<SecuenciaEmision> buscarTodosSecuenciaEmision() {
        return this.secuenciaEmisionService.buscarTodasSecuenciasEmisiones();
    }

    @PreAuthorize("hasPermission('MANT_SECUENCIA_EMISION', '1')")
    @PostMapping(value = "/secuencias-emisiones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public SecuenciaEmision registrarSecuenciaEmision(@Validated({IRegistro.class, Default.class}) @RequestBody SecuenciaEmision secuenciaEmision) {
        return this.secuenciaEmisionService.registrarSecuenciaEmision(secuenciaEmision);
    }

    @PreAuthorize("hasPermission('MANT_SECUENCIA_EMISION', '3')")
    @PutMapping(value = "/secuencias-emisiones/{idSecuenciaEmision}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SecuenciaEmision actualizarSecuenciaEmision(@PathVariable("idSecuenciaEmision") Integer idSecuenciaEmision,
                                                       @Validated({IRegistro.class, Default.class}) @RequestBody SecuenciaEmision secuenciaEmision) {
        return this.secuenciaEmisionService.actualizarSecuenciaEmision(idSecuenciaEmision, secuenciaEmision);
    }

    @PreAuthorize("hasPermission('MANT_SECUENCIA_EMISION', '4')")
    @DeleteMapping("/secuencias-emisiones/{idSecuenciaEmision}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarSecuenciaEmision(@PathVariable("idSecuenciaEmision") Integer idSecuenciaEmision) {
        this.secuenciaEmisionService.eliminarSecuenciaEmision(idSecuenciaEmision);
    }
}
