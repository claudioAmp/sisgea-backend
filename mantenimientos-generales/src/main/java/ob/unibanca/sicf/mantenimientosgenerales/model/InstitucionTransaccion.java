package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitucionTransaccion {
	
	private int idInstitucion;
	private String descripcionInstitucion;
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idClaseTransaccion;
	private String descripcionClaseTransaccion;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private int idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
}
