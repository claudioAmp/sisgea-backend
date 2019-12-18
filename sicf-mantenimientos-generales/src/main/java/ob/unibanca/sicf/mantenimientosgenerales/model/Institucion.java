package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterNoRequerido;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.NumeroNoRequerido;
import ob.commons.spring.validation.validation.group.IRegistro;

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

	private Boolean esBancoAdministrador;

	private String tipoInstitucion;
	private String descripcionTipoInstitucion;

	private boolean esProcesador;

	@CaracterNoRequerido(minLength = 1, maxLength = 15)
	private String cuentaContableMonedaBase;

	@CaracterNoRequerido(minLength = 1, maxLength = 15)
	private String cuentaContableMonedaAlterna;

	@NumeroNoRequerido(maxRange = 99999)
	private Integer idInstitucionOperador;
	private String descripcionInstitucionOpe;

	// nuevos datos
	private Integer tipoAdquirente;
	private Boolean cuentaCompensacion;
	private Boolean esAdquirenteAtm;
	private Boolean esAdquirenteVentanilla;
	private Boolean activo;
    private Boolean esMiembroPrincipalVisa;
    private Boolean esMiembroPrincipalMc;
    private String bidVisa;
    private String icaMcEmisor;
    private String icaMcAdquirente;
    private String pcrCreditoVisa;
	private String pcrDebitoVisa;
	private Boolean esLogAntiguoContable;
	private Boolean siAplicaBancoAdministrador;
	private Integer idInstitucionBidNoPropio;
	private String descripcionInstitucionBidNoPropio;
	private Boolean siCompensaOpeSoles;
	private Boolean siCompensaOpeDolares;
	private Boolean siAplicaBidVisaPropio;
	private Boolean siCompensaOpeBidVisa;
}
