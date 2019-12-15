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
public class ModoEntradaPOS{
	
	private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 2, regexpPattern = "[A-Z0-9]+", groups = IRegistro.class)
	private String idModoEntradaPOS;
	@CaracterRequerido(maxLength = 80)
	private String descripcionModoEntradaPOS;

}