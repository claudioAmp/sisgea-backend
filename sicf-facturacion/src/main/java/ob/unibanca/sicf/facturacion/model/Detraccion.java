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
public class Detraccion {
	@IdNumerico(maxRange = 999999, groups = IRegistro.class)
	private Integer idDetraccion;
	@CaracterRequerido(maxLength = 100)
	private String descripcionDetraccion;
	private Double porcentajeDetraccion;
}
