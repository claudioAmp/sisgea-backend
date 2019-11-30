package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ProgramaBIN;
import ob.unibanca.sicf.mantenimientosgenerales.service.programabin.IProgramaBINService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
@RequestMapping(value="/programas-bin")
public class ProgramaBINRestController {

    private final IProgramaBINService programaBINService;

    public ProgramaBINRestController(IProgramaBINService programaBinService) {
        this.programaBINService = programaBinService;
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '2')")
    @GetMapping
    public List<ProgramaBIN> buscarTodosProgramaBin() {
        return this.programaBINService.buscarTodosProgramasBin();
    }

    // TODO(IdNumerico-max): Cuanto es el maximo para @IdNumerico (99'999 o 9'999)?
    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '2')")
    @GetMapping(value ="/{id-membresia}/{id-producto}/{id-programa}")
    public ProgramaBIN buscarProgramaBin(
        @IdCadena(maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable("id-membresia") String idMembresia,
        @IdNumerico(maxRange = 99999) @PathVariable("id-producto") Integer idProducto,
        @IdNumerico(maxRange = 99999) @PathVariable("id-programa") Integer idPrograma) {
        return this.programaBINService.buscarProgramaBin(idMembresia, idProducto, idPrograma);
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '1')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProgramaBIN registrarProgramaBin(
        @Validated({IRegistro.class, Default.class}) @RequestBody ProgramaBIN programaBin) {
        return this.programaBINService.registrarProgramaBin(programaBin);
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '3')")
    @PutMapping(value="/{id-membresia}/{id-producto}/{id-programa}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProgramaBIN actualizarProgramaBin(
            @IdCadena(maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable("id-membresia") String idMembresia,
            @IdNumerico(maxRange = 99999) @PathVariable("id-producto") Integer idProducto,
            @IdNumerico(maxRange = 99999) @PathVariable("id-programa") Integer idPrograma,
            @Validated({IRegistro.class, Default.class}) @RequestBody ProgramaBIN programaBin) {
        return this.programaBINService.actualizarProgramaBin(idMembresia, idProducto, idPrograma, programaBin);
    }

    @PreAuthorize("hasPermission('MANT_PROGRAMA_BIN', '4')")
    @DeleteMapping("/{id-membresia}/{id-producto}/{id-programa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarProgramaBin(
            @IdCadena(maxLength = 1, regexpPattern = "[a-zA-Z]")  @PathVariable("id-membresia") String idMembresia,
        @IdNumerico(maxRange = 99999) @PathVariable("id-producto") Integer idProducto,
        @IdNumerico(maxRange = 99999) @PathVariable("id-programa") Integer idPrograma) {
        this.programaBINService.eliminarProgramaBin(idMembresia, idProducto, idPrograma);
    }
}
