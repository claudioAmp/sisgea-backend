package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.taller.sisgea.mantenimientosgenerales.model.TipoIrregular;
import edu.taller.sisgea.mantenimientosgenerales.service.tipoirregular.ITipoIrregularService;

@RestController
public class TipoIrregularRestController {
	private final ITipoIrregularService tipoIrregularService;
	
	public TipoIrregularRestController(ITipoIrregularService tipoIrregularService) {
		this.tipoIrregularService = tipoIrregularService;
	}

	@GetMapping("/tipos-irregular")
	public List<TipoIrregular> buscarTodosTiposIrregular() {
		return this.tipoIrregularService.buscarTodosTiposIrregular();
	}
}
