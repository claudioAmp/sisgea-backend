package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.BINVisa;
import ob.unibanca.sicf.mantenimientosgenerales.service.binvisa.IBINVisaService;

@Validated
@RestController
public class BINVisaRestController {
	
	private final IBINVisaService binVisaService;
	
	public BINVisaRestController (IBINVisaService binVisaService){
		this.binVisaService = binVisaService;
	}
	
	
	//@PreAuthorize("hasPermission('MANT_BIN_VISA', '2')")
	@GetMapping(value = "/binsVisa")
	public List<BINVisa> buscarTodosBINs() {
		return this.binVisaService.buscarTodosBINVisa();
	}
	
}
