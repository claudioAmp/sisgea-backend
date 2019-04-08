package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.unibanca.sicf.mantenimientosgenerales.model.TransaccionMarcaInt;
import ob.unibanca.sicf.mantenimientosgenerales.service.transaccionmarcaint.ITransaccionMarcaIntService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import ob.commons.validation.validation.IdCadena;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
public class TransaccionMarcaIntRestController {
	
	private final ITransaccionMarcaIntService transaccionMarcaInt;
	
	public TransaccionMarcaIntRestController(ITransaccionMarcaIntService transaccionMarcaInt) {
		this.transaccionMarcaInt = transaccionMarcaInt;
	}
	
	@GetMapping("/transacciones-marcas-internacionales")
	public List<TransaccionMarcaInt> buscarTodosTransaccionMarcaInts() {
		return this.transaccionMarcaInt.buscarTodasTransaccionesMarcaInt();
   }
	
	@GetMapping("/transacciones-marcas-internacionales/{idMembresia}")
	public List<TransaccionMarcaInt> buscarTodosTransaccionMarcaIntsPorMembresia(
      @IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
      return this.transaccionMarcaInt.buscarTodasTransaccionesMarcaInt()
                                       .stream()
                                       .filter(txn->txn.getIdMembresia().equals(idMembresia))
                                       .collect(Collectors.toList());
   }
   
}
