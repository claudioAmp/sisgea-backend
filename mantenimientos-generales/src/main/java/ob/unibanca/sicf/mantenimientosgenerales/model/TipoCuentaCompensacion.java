package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.NumeroNoRequerido;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCuentaCompensacion {
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idTipoCuentaComp;
	@CaracterRequerido(maxLength = 30)
	private String descripcionTipoCuentaComp;
	@NumeroNoRequerido(maxRange = 99999)
	private int idCuentaComp;
	@CaracterRequerido(maxLength = 1)
	private String cuentaIntercambio;
	private String descripcionCuentaComp;
}
