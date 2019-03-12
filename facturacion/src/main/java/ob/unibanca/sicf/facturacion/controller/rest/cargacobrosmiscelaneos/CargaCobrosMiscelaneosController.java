package ob.unibanca.sicf.facturacion.controller.rest.cargacobrosmiscelaneos;

import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosVisaService;

@Validated
@RestController
public class CargaCobrosMiscelaneosController {
    
    private final ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService;
    
	public CargaCobrosMiscelaneosController(ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService) {
		this.cargaCobrosMiscelaneosVisaService = cargaCobrosMiscelaneosVisaService;
    }
    
    @PostMapping(value = "/visa/cobros-miscelaneos/upload")
    public String cargarArchivoVisa(@RequestParam("file") MultipartFile multipartfile, ModelMap modelMap) {
        return cargaCobrosMiscelaneosVisaService.cargarArchivos(multipartfile);
    }

    @PostMapping(value = "/mc/cobros-miscelaneos/upload")
    public String cargarArchivoMC(@RequestParam("file") MultipartFile multipartfile, ModelMap modelMap) {
        // Por implementar
        return "";
    }
    
}