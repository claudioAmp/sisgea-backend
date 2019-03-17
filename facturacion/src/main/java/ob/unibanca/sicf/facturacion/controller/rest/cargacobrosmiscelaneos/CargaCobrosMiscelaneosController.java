package ob.unibanca.sicf.facturacion.controller.rest.cargacobrosmiscelaneos;

import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import ob.commons.validation.model.ErrorResponse;

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
    public List<ErrorResponse> cargarArchivoVisa(@RequestParam("files") List<MultipartFile> multipartfiles, ModelMap modelMap) {
        return cargaCobrosMiscelaneosVisaService.cargarArchivos(multipartfiles);
    }

    @PostMapping(value = "/mc/cobros-miscelaneos")
    public List<ErrorResponse> cargarArchivoMC(@RequestParam("files") List<MultipartFile> multipartfiles, ModelMap modelMap) {
        return cargaCobrosMiscelaneosMCService.cargarArchivos(multipartfiles);
    }

}