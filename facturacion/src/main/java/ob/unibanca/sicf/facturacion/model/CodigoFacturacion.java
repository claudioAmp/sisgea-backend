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
public class CodigoFacturacion {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idCodigoFacturacion;
	@CaracterRequerido(maxLength = 100)
	private String descripcionCodigoFacturacion;
}
