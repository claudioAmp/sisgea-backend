package ob.unibanca.sicf.facturacion.controller.rest.cargacobrosmiscelaneos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
	public ResponseEntity cargarArchivoVisa(@RequestParam("file[]") List<MultipartFile> file) {
		try {
			this.cargaCobrosMiscelaneosVisaService.cargarArchivos(file);
        } catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Carga fallida");
        }
		return ResponseEntity.status(HttpStatus.OK).body("Registro exitoso");
	}
	
	@PostMapping(value = "/mc/cobros-miscelaneos")
	public ResponseEntity cargarArchivoMC(@RequestParam("file[]") List<MultipartFile> file) {
		try {
			this.cargaCobrosMiscelaneosMCService.cargarArchivos(file);
        } catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Carga fallida pz");
        }
		return ResponseEntity.status(HttpStatus.OK).body("Registro exitoso");
	}
}