package ob.unibanca.sicf.facturacion.controller.rest.cargacobrosmiscelaneos;

import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosVisaService;
import ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos.ICargaCobrosMiscelaneosMCService;

@Validated
@RestController
public class CargaCobrosMiscelaneosController {

    private final ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService;
    private final ICargaCobrosMiscelaneosMCService cargaCobrosMiscelaneosMCService;

    public CargaCobrosMiscelaneosController(ICargaCobrosMiscelaneosVisaService cargaCobrosMiscelaneosVisaService,
            ICargaCobrosMiscelaneosMCService cargaCobrosMiscelaneosMCService) {
        this.cargaCobrosMiscelaneosVisaService = cargaCobrosMiscelaneosVisaService;
        this.cargaCobrosMiscelaneosMCService = cargaCobrosMiscelaneosMCService;
    }

    @PostMapping(value = "/visa/cobros-miscelaneos")
    public void cargarArchivoVisa(@RequestParam("files") List<MultipartFile> multipartfiles, ModelMap modelMap) {
        cargaCobrosMiscelaneosVisaService.cargarArchivos(multipartfiles);
    }

    @PostMapping(value = "/mc/cobros-miscelaneos")
    public void cargarArchivoMC(@RequestParam("files") List<MultipartFile> multipartfiles, ModelMap modelMap) {
        cargaCobrosMiscelaneosMCService.cargarArchivos(multipartfiles);
    }

}