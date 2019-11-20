package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CorreoTelefono{
	@IdCadena(minLength = 1, maxLength = 1)
	private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 2, regexpPattern = "[0-9]+", groups = IRegistro.class)
	private String idCorreoTelefono;
	@CaracterRequerido(maxLength = 80)
	private String descripcionIndCorreoTel;
	
}