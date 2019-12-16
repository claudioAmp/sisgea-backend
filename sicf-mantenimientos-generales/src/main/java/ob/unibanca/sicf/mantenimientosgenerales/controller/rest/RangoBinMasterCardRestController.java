package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.RangoBINMasterCard;
import ob.unibanca.sicf.mantenimientosgenerales.service.rangobinmc.IRangoBinMasterCardService;


@Validated
@RestController
public class RangoBinMasterCardRestController {
	
	private final IRangoBinMasterCardService rangoBinMasterCard;
	
	public RangoBinMasterCardRestController (IRangoBinMasterCardService rangoBinMasterCard){
		this.rangoBinMasterCard = rangoBinMasterCard;
	}
	
	
	//@PreAuthorize("hasPermission('MANT_BIN_VISA', '2')")
	//@GetMapping(value = "/rangoBinesMC")
	public List<RangoBINMasterCard> buscarTodosBINs() {
		return this.rangoBinMasterCard.buscarTodosBinesMasterCard();
	}
	
}
