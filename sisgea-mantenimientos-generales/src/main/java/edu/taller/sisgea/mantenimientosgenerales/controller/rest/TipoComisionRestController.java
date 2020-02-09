package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.TipoComision;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.mantenimientosgenerales.service.tipocomision.ITipoComisionService;

@Validated
@RestController
public class TipoComisionRestController {
	private final ITipoComisionService tipoComisionService;
	
	public TipoComisionRestController(ITipoComisionService tipoComisionService) {
		this.tipoComisionService = tipoComisionService;
	}	
	
	@GetMapping("/tipos-comisiones")
	public List<TipoComision> buscarTodosTiposComision(){
		return this.tipoComisionService.buscarTodosTiposComision();
	}
	
	@GetMapping("/tipos-comisiones/{idTipoComision}")
	public TipoComision buscarPorIdTipoComision(@PathVariable Integer idTipoComision){
		return this.tipoComisionService.buscarPorIdTipoComision(idTipoComision);
	}
}
