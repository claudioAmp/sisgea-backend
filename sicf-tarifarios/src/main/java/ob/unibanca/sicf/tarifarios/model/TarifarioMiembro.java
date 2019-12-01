package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarifarioMiembro {
	
	private Integer idTarifarioMiembro;
	@IdCadena(minLength = 1, maxLength = 999, regexpPattern = "[a-zA-Z]")
	private String idMembresia;
	private String descripcionMembresia;
	@IdNumerico(minRange = 0, maxRange = 999)
	private Integer idProducto;
	private String descripcionProducto;
	@IdNumerico(maxRange = 99999)
	private Integer idInstitucionEmisora;
	private String descripcionInstitucionEmisora;
	@IdNumerico(maxRange = 99999)
	private Integer idInstitucionReceptora;
	private String descripcionInstitucionReceptora;
	@IdNumerico(maxRange = 99999)
	private Integer idClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descripcionTransaccion;
	@IdNumerico(minRange = 0, maxRange = 999)
	private Integer idMoneda;
	private String descripcionMoneda;
	@CaracterRequerido(maxLength = 20)
	private boolean atmPropio;
	private boolean transaccionAprobada;
	private Integer tarifaPorcentaje;
	private Integer tarifaFlat;
	

}
