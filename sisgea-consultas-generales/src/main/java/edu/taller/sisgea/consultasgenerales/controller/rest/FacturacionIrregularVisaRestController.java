package edu.taller.sisgea.consultasgenerales.controller.rest;

import java.util.List;

import edu.taller.sisgea.consultasgenerales.service.facturacionirregularvisa.IFacturacionIrregularVisaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.consultasgenerales.model.facturacionirregularvisa.FacturacionIrregularVisa;
import edu.taller.sisgea.consultasgenerales.service.facturacionirregularvisa.IFacturacionIrregularVisaService;

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
    public List<FacturacionIrregularVisa> buscarTodasFacturacionesIrregularVisa() {
        return this.facturacionIrregularVisaService.buscarTodosFacturacionIrregularVisa();
    }
}
