package ob.unibanca.sicf.facturacion.controller.rest.cargacobrosmiscelaneos;

import ob.commons.error.model.ErrorResponse;
import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosMCService;
import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosVisaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.net.MediaType;

import java.util.List;

@Validated
@RestController
public class CargaCobrosMiscelaneosRestController {
	
	private final ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService;
	private final ICargaCobrosMiscelaneosMCService cargaCobrosMiscelaneosMCService;
	
	public CargaCobrosMiscelaneosRestController(ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService,
	                                        ICargaCobrosMiscelaneosMCService cargaCobrosMiscelaneosMCService) {
		this.cargaCobrosMiscelaneosVisaService = cargaCobrosMiscelaneosVisaService;
		this.cargaCobrosMiscelaneosMCService = cargaCobrosMiscelaneosMCService;
	}
	
	@PostMapping(value = "/visa/cobros-miscelaneos")
	public ResponseEntity cargarArchivoVisa(@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		try {
			this.cargaCobrosMiscelaneosVisaService.cargarArchivos(file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Carga fallida");
        }
		return ResponseEntity.status(HttpStatus.OK).body("Registro exitoso");
	}
	
	@PostMapping(value = "/mc/cobros-miscelaneos")
	public ResponseEntity cargarArchivoMC(@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		try {
			this.cargaCobrosMiscelaneosVisaService.cargarArchivos(file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Carga fallida");
        }
		return ResponseEntity.status(HttpStatus.OK).body("Registro exitoso");
	}
}