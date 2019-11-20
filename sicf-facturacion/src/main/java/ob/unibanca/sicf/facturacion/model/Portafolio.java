package ob.unibanca.sicf.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portafolio {
	
	@IdNumerico(maxRange = 999, groups = IRegistro.class)
	private int idPortafolio;
	@CaracterRequerido(maxLength = 40)
	private String descripcionPortafolio;
}
