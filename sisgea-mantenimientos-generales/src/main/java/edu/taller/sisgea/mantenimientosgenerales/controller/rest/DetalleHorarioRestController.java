package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.model.DetalleHorario;
import edu.taller.sisgea.mantenimientosgenerales.model.resultadocarga.ResultadoCarga;
import edu.taller.sisgea.mantenimientosgenerales.service.detallerhorario.IDetalleHorarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class DetalleHorarioRestController {

    private final IDetalleHorarioService detalleHorarioService;

    public DetalleHorarioRestController(IDetalleHorarioService detalleHorarioService) {
        this.detalleHorarioService = detalleHorarioService;
    }

    @GetMapping(value = "/detalleHorario")
    public List<DetalleHorario> buscarTodosDetalleHorario() {
        return this.detalleHorarioService.buscarTodosDetalleHorario();
    }

    @PostMapping(value = "/detalleHorario/cargar")
    public List<ResultadoCarga> cargarArchivo(@RequestParam("file[]") List<MultipartFile> file){
        return this.detalleHorarioService.cargarArchivos(file);
    }

}
