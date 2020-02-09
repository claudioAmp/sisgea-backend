package edu.taller.sisgea.consultasgenerales.controller.rest;

import edu.taller.sisgea.consultasgenerales.service.facturacionirregularmastercard.IFacturacionIrregularMasterCardService;
import edu.taller.sisgea.consultasgenerales.model.facturacionirregularmastercard.FacturacionIrregularMasterCard;
import edu.taller.sisgea.consultasgenerales.service.facturacionirregularmastercard.IFacturacionIrregularMasterCardService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class FacturacionIrregularMasterCardRestController {

    private final IFacturacionIrregularMasterCardService facturacionIrregularMasterCardService;

    public FacturacionIrregularMasterCardRestController (IFacturacionIrregularMasterCardService facturacionIrregularMasterCardService)
    {
        this.facturacionIrregularMasterCardService = facturacionIrregularMasterCardService;
    }


    @PreAuthorize("hasPermission('CON_FACTURA_MC_IRR', '2')")
    @GetMapping(value = "/facturaciones-irregular-master-card")
    public List<FacturacionIrregularMasterCard> buscarTodasFacturacionesIrregularMasterCard() {
        return this.facturacionIrregularMasterCardService.buscarTodosFacturacionIrregularMasterCard();
    }
}
