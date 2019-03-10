package ob.unibanca.sicf.facturacion.controller.rest.cargacobrosmiscelaneos;

import java.io.File;

import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosVisaService;

@Validated
@RestController
public class CargaCobrosMiscelaneosController {
    
    private final ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService;
    
	public CargaCobrosMiscelaneosController(ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService) {
		this.cargaCobrosMiscelaneosVisaService = cargaCobrosMiscelaneosVisaService;
    }
    
    @PostMapping(value = "/visa/cobros-miscelaneos/upload")
    public String cargarArchivoVisa(@RequestParam("file") MultipartFile multifile, ModelMap modelMap) {
        File file = new File(multifile.getOriginalFilename());
        try {
            multifile.transferTo(file);
            return cargaCobrosMiscelaneosVisaService.cargarArchivos(file);
        } catch (Exception e) {
            throw new RecursoNoEncontradoException("Raios, we: %s", e.getMessage());
        }

    }

    @PostMapping(value = "/mc/cobros-miscelaneos/upload")
    public String cargarArchivoMC(@RequestParam("file") MultipartFile multifile, ModelMap modelMap) {
        File file = new File(multifile.getOriginalFilename());
        try {
            multifile.transferTo(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ("<b>original name: </b>" + multifile.getOriginalFilename() + "<br><b>content type: </b>"
                + multifile.getContentType());
    }
    
}