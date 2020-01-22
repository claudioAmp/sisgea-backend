package ob.unibanca.sicf.facturacion.controller.rest.cargacobrosmiscelaneos;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ob.unibanca.sicf.facturacion.model.resultado.ResultadoCargaFactura;
import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosMCService;
import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosVisaService;

@Validated
@RestController
public class CargaCobrosMiscelaneosRestController {
	
	private final ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService;
	private final ICargaCobrosMiscelaneosMCService cargaCobrosMiscelaneosMCService;
	
	public CargaCobrosMiscelaneosRestController(ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService, ICargaCobrosMiscelaneosMCService cargaCobrosMiscelaneosMCService) {
		this.cargaCobrosMiscelaneosVisaService = cargaCobrosMiscelaneosVisaService;
		this.cargaCobrosMiscelaneosMCService = cargaCobrosMiscelaneosMCService;
	}
	
	@PostMapping(value = "/visa/cobros-miscelaneos")
	public List<ResultadoCargaFactura> cargarArchivoVisa(@RequestParam("file[]") List<MultipartFile> file){
		return this.cargaCobrosMiscelaneosVisaService.cargarArchivos(file);
	}
	
	@PostMapping(value = "/mc/cobros-miscelaneos")
	public List<ResultadoCargaFactura> cargarArchivoMC(@RequestParam("file[]") List<MultipartFile> file) {
		return this.cargaCobrosMiscelaneosMCService.cargarArchivos(file);
	}
	
}