package ob.unibanca.sicf.facturacion.controller;

import ob.unibanca.sicf.facturacion.model.Portafolio;
import ob.unibanca.sicf.facturacion.service.portafolio.IPortafolioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento/facturacion")
public class PortafolioRestController {
	
	private final IPortafolioService portafolioService;
	
	public PortafolioRestController(IPortafolioService portafolioService) {
		this.portafolioService = portafolioService;
	}
	
	@GetMapping("portafolios")
	public List<Portafolio> buscarTodosPortafolios() {
		return this.portafolioService.buscarTodosPortafolios();
	}
}
