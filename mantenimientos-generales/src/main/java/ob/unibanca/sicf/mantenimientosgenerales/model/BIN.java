package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.NumeroNoRequerido;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BIN {
	
	@IdCadena(minLength = 6, maxLength = 15, regexpPattern = "[0-9]+", groups = IRegistro.class)
	private String idBIN;
	@CaracterRequerido(minLength = 1, maxLength = 20)
	private String descripcion;
	private boolean esInternacional;
	private double valorOIF;
	@NumeroNoRequerido(maxRange = 99)
	private int longitudPAN;
	@IdNumerico(maxRange = 99999)
	private int idInstitucion;
	private String descripcionInstitucion;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]")
	private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]")
	private String idServicio;
	private String descripcionServicio;
	@IdNumerico(maxRange = 999)
	private int idMonedaBase;
	private String descripcionMonedaBase;
	@IdNumerico(maxRange = 999)
	private int idMonedaAlterna;
	private String descripcionMonedaAlterna;
}
