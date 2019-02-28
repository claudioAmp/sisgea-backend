package ob.unibanca.sicf.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.Descripcion;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portafolio {
	
	@IdNumerico(maxRange = 999, groups = IRegistro.class)
	private int idPortafolio;
	@Descripcion(minLength = 1, maxLength = 40)
	private String descripcion;
}
