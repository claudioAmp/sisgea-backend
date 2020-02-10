package edu.taller.sisgea.mantenimientosgenerales.controller.rest;


import edu.taller.sisgea.mantenimientosgenerales.model.Docente;
import edu.taller.sisgea.mantenimientosgenerales.service.docente.IDocenteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocenteRestController {

    private final IDocenteService docenteService;

    public DocenteRestController(IDocenteService docenteService) {this.docenteService = docenteService;}

    @GetMapping("/docentes")
    public List<Docente> buscarTodosDocentes() {return this.docenteService.buscarTodosDocentes();}

}
