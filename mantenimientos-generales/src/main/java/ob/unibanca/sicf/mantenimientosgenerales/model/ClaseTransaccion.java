package ob.unibanca.sicf.mantenimientosgenerales.model;

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
public class ClaseTransaccion {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private Integer idClaseTransaccion;
	@CaracterRequerido(maxLength = 50)
	private String descripcion;
	@CaracterRequerido(maxLength = 2)
	private String tipoTransaccion;
}
