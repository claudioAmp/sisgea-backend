package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ob.unibanca.sicf.mantenimientosgenerales.model.IndLimitePiso;
import ob.unibanca.sicf.mantenimientosgenerales.service.indlimitepiso.IIndLimitePisoService;
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
