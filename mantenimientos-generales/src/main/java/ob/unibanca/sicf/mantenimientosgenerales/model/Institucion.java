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
public class Institucion {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idInstitucion;
	@CaracterRequerido(minLength = 1, maxLength = 80, nombreCampo = "La descripción")
	private String descripcion;
	@CaracterRequerido(minLength = 1, maxLength = 20, nombreCampo = "La descripción corta")
	private String descripcionCorta;
	private String razonSocial;
	private String ruc;
	private String direccion;
	private boolean esBancoAdministrador;
	private String tipoInstitucion;
	private boolean esProcesador;
	private String cuentaContableMonedaBase;
	private String cuentaContableMonedaAlterna;
	@IdNumerico(maxRange = 99999)
	private int idInstitucionOperador;
}
