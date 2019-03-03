package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
	
	private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private String idServicio;
	@CaracterRequerido(maxLength = 20)
	private String descripcionServicio;
}
