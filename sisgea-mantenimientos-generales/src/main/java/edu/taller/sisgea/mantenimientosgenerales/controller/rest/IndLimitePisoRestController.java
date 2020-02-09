package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.taller.sisgea.mantenimientosgenerales.model.IndLimitePiso;
import edu.taller.sisgea.mantenimientosgenerales.service.indlimitepiso.IIndLimitePisoService;
@Validated
@RestController
public class IndLimitePisoRestController {
	private final IIndLimitePisoService indLimitePisoService;
	
	public IndLimitePisoRestController(IIndLimitePisoService indLimiteService) {
		this.indLimitePisoService = indLimiteService;
	}
	@PreAuthorize("hasPermission('MANT_INDLIMPISO', '2')")
	@GetMapping(value = "/inds-limites-pisos")
	public List<IndLimitePiso> buscarTodosIndLimitePiso() {
		return this.indLimitePisoService.buscarTodosIndLimitePiso();
	}
}
