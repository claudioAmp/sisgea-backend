package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.NumeroNoRequerido;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCuentaCompensacion {
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idTipoCuentaComp;
	@CaracterRequerido(maxLength = 30)
	private String descripcionTipoCuentaComp;
	@NumeroNoRequerido(maxRange = 99999)
	private Integer idCuentaComp;
	@CaracterRequerido(maxLength = 1)
	private String cuentaIntercambio;
	private String descripcionCuentaComp;
}
