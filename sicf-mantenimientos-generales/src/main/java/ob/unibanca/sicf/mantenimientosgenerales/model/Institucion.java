package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterNoRequerido;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Institucion {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private Integer idInstitucion;
	@CaracterRequerido(maxLength = 80)
	private String descripcionInstitucion;
	@CaracterRequerido(maxLength = 20)
	private String descripcionCorta;
	@CaracterNoRequerido(minLength = 1, maxLength = 40)
	private String razonSocial;
	@CaracterNoRequerido(minLength = 11, maxLength = 12, regexpPattern = "[0-9]+")
	private String ruc;
	@CaracterNoRequerido(minLength = 1, maxLength = 120)
	private String direccion;
	private boolean esBancoAdministrador;
	private String tipoInstitucion;
	private String descripcionTipoInstitucion;
	private boolean esProcesador;
	@CaracterNoRequerido(minLength = 1, maxLength = 15, regexpPattern = "[0-9]+")
	private String cuentaContableMonedaBase;
	@CaracterNoRequerido(minLength = 1, maxLength = 15, regexpPattern = "[0-9]+")
	private String cuentaContableMonedaAlterna;
	@IdNumerico(maxRange = 99999)
	private Integer idInstitucionOperador;
	private String descripcionInstitucionOpe;
}
