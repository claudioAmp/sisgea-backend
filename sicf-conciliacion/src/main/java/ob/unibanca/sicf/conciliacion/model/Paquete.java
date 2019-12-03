package ob.unibanca.sicf.conciliacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paquete {
	
	private Integer idPaquete;
	@CaracterRequerido(maxLength = 50)
	private String descripcionPaquete;
	@CaracterRequerido(maxLength = 50)
	private String nombrePaquete;
	
}
