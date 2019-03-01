package ob.unibanca.sicf.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portafolio {
	
	@IdNumerico(maxRange = 999, groups = IRegistro.class)
	private int idPortafolio;
	@CaracterRequerido(minLength = 1, maxLength = 40, nombreCampo = "La descripción")
	private String descripcion;
}
