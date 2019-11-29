package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

@Validated
@RestController
@RequestMapping(value="/programa-bin")
public class ProgramaBINRestController {

    private final IProgramaBinService programaBinService;

    public ProgramaBinRestController(IProgramaBinService ProgramaBinService) {
        this.programaBinService = ProgramaBinService;
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '2')")
    @GetMapping
    public List<ProgramaBin> buscarTodosProgramaBin() {
        return this.programaBinService.buscarTodosProgramaBin();
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '2')")
    @GetMapping(value ="/{id-membresia}/{id-producto}/{id-programa}")
    public ProgramaBin buscarProgramaBin(
        @IdCadena(maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable("id-membresia") String idMembresia,
        @IdNumerico(maxRange = 9999) @PathVariable("id-producto") Integer idProducto,
        @IdNumerico(maxRange = 9999) @PathVariable("id-programa") Integer idPrograma) {
        return this.programaBinService.buscarProgramaBin(idMembresia, idProducto, idPrograma);
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '1')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProgramaBin registrarProgramaBin(
        @Validated({IRegistro.class, Default.class}) @RequestBody ProgramaBin programaBin) {
        return this.programaBinService.registrarProgramaBin(programaBin);
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '3')")
    @PutMapping(value="/{id-membresia}/{id-producto}/{id-programa}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProgramaBin actualizarProgramaBin(
            @IdCadena(maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable("id-membresia") String idMembresia,
            @IdNumerico(maxRange = 9999) @PathVariable("id-producto") Integer idProducto,
            @IdNumerico(maxRange = 9999) @PathVariable("id-programa") Integer idPrograma,
            @Validated({IRegistro.class, Default.class}) @RequestBody ProgramaBin programaBin) {
        return this.programaBinService.actualizarProgramaBin(idMembresia, idProducto, idPrograma, programaBin);
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '4')")
    @DeleteMapping("/{id-membresia}/{id-producto}/{id-programa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarProgramaBin(
            @IdCadena(maxLength = 1, regexpPattern = "[a-zA-Z]")  @PathVariable("id-membresia") String idMembresia,
        @IdNumerico(maxRange = 9999) @PathVariable("id-producto") Integer idProducto,
        @IdNumerico(maxRange = 9999) @PathVariable("id-programa") Integer idPrograma) {
        this.programaBinService.eliminarProgramaBin(idMembresia, idProducto, idPrograma);
    }
}
