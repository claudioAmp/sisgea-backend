package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.NumeroNoRequerido;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BIN {
	
	@IdCadena(minLength = 6, maxLength = 15, regexpPattern = "[0-9]+", groups = IRegistro.class)
	private String idBIN;
	@CaracterRequerido(maxLength = 20)
	private String descripcionBIN;
	private boolean esInternacional;
	@IdNumerico(maxRange = 99999999, minRange = 0)
	private double valorOIF;
	@NumeroNoRequerido(maxRange = 99)
	private Integer longitudPAN;

	@IdNumerico(maxRange = 99999)
	private Integer idInstitucion;
	private String descripcionInstitucion;
	private String descripcionCortaInstitucion;

	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]")
	private String idMembresia;
	private String descripcionMembresia;

	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]")
	private String idServicio;
	private String descripcionServicio;

	@IdNumerico(minRange = 0, maxRange = 999)
	private Integer idMonedaBase;
	private String descripcionMonedaBase;

	@IdNumerico(minRange = 0, maxRange = 999)
	private Integer idMonedaAlterna;
	private String descripcionMonedaAlterna;

	// TODO(): idProducto es obligatorio?
	private Integer idProducto;
	private String descripcionProducto;

	// TODO(): idPrograma es obligatorio?
	private Integer idPrograma;
	private String abreviaturaPrograma;

	private Boolean sreVisaSoles;
	private Boolean sreVisaDolares;
	private Boolean siCompensaOpeBinVisa;
	private Boolean siCompensaOpeSreSolesVisa;
	private Boolean siCompensaOpeSreDolaresVisa;
	private Boolean siFacturaEventoBinVisa;
	private Boolean siFacturaEventoSreSolesVisa;
	private Boolean siFacturaEventoSreDolaresVisa;
}
