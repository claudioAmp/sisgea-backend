package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionMarcaInt {
	
	private String idMembresia;
	//private String descripcionMembresia;
	private String idTransaccion;
	@CaracterRequerido(maxLength = 20)
   private String descripcionTransaccion;
   
}
