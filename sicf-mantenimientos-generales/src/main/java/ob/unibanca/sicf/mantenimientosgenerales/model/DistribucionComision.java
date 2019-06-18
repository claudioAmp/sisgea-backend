package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistribucionComision {
	
	private Integer idDistribucionComision;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private String idServicio;
	private String descripcionServicio;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idOrigen;
	private String descripcionOrigen;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idClaseTransaccion;
	private String descripcionClaseTransaccion;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
	@IdNumerico(maxRange = 999, groups = IRegistro.class)
	private Integer idTipoComision;
	private String descripcionTipoComision;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idCuentaCargo;
	private String descripcionCuentaCargo;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idCuentaAbono;
	private String descripcionCuentaAbono;

}
