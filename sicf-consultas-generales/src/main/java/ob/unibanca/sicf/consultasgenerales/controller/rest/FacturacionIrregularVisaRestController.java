package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.consultasgenerales.model.facturacionirregularvisa.FacturacionIrregularVisa;
import ob.unibanca.sicf.consultasgenerales.service.facturacionirregularvisa.IFacturacionIrregularVisaService;

@Validated
@RestController
public class FacturacionIrregularVisaRestController {

    private final IFacturacionIrregularVisaService facturacionIrregularVisaService;

    public FacturacionIrregularVisaRestController (IFacturacionIrregularVisaService facturacionIrregularVisaService)
    {
        this.facturacionIrregularVisaService = facturacionIrregularVisaService;
    }


    @PreAuthorize("hasPermission('CON_FACTURA_VISA_IRR', '2')")
    @GetMapping(value = "/facturaciones-irregular-visa")
    public List<FacturacionIrregularVisa> buscarTodosBINs() {
        return this.facturacionIrregularVisaService.buscarTodosFacturacionIrregularVisa();
    }
}
