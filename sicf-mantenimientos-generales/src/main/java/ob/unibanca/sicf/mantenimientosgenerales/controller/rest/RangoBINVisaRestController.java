package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.BINVisa;
import ob.unibanca.sicf.mantenimientosgenerales.model.RangoBINVisa;
import ob.unibanca.sicf.mantenimientosgenerales.service.binvisa.IBINVisaService;
import ob.unibanca.sicf.mantenimientosgenerales.service.rangobinvisa.IRangoBINVisaService;

@Validated
@RestController
public class RangoBINVisaRestController {
	
	private final IRangoBINVisaService rangoBinVisaService;
	
	public RangoBINVisaRestController (IRangoBINVisaService rangoBinVisaService){
		this.rangoBinVisaService = rangoBinVisaService;
	}
	
	
	//@PreAuthorize("hasPermission('MANT_BIN_VISA', '2')")
	@GetMapping(value = "/rangoBinesVISA")
	public List<RangoBINVisa> buscarTodosBINs() {
		return this.rangoBinVisaService.buscarTodosRangoBINVisa();
	}
	
}
