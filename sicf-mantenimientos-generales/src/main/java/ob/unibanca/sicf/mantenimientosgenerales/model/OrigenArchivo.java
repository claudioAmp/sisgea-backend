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
public class OrigenArchivo {
	
	@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "[0-9]+", groups = IRegistro.class)
	private String idOrigenArchivo;
	@CaracterRequerido(maxLength = 30)
	private String descripcionOrigenArchivo;
	private boolean concilia;
	
}
