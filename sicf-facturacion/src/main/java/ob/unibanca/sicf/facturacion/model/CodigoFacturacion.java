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
public class CodigoFacturacion {

	/*Missmatch Error*/

	private Integer idDetraccion;

	private String descIdDetraccion;

	private Integer indTipoFacturacion;

	private String descIndTipoFacturacion;

	private String idOrigenFacturacion;

	private String descIdOrigenFacturacion;

	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private Integer idCodigoFacturacion;

	@CaracterRequerido(maxLength = 100)
	private String descIdCodigoFacturacion;

}
