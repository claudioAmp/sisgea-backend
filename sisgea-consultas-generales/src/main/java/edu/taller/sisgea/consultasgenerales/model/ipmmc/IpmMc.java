package edu.taller.sisgea.consultasgenerales.model.ipmmc;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IpmMc {
	
	private String tramsKey;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	@TruncarPAN
	private String pan;
	private String typeRecord;
	private String descTypeRecord;
	private Double amountTxn;
	private Double amountCardholder;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateLocalTxn;
	private String timeLocalTxn;
	private String cardDataInputCapability;
	private String descCardDataInputCapability;
	private String cardDataInputMode;
	private String descCardDataInputMode;
	private String cardhAuthenticationMethod;
	private String descCardhAuthenticationMethod;
	private String cardAcceptorBusinessCode;
	private String descCardAcceptorBusinessCode;
	private String acquirerReferenceData;
	private String approvalCode;
	private String cardAcceptorName;
	private String cardAcceptorCountrycode;
	private String descCardAcceptorCountrycode;
	private Integer currencyCodeTransaction;
	private String descCurrencyCodeTransaction;
	private Integer currencyCodeCardholder;
	private String descCurrencyCodeCardholder;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date settlDate;
	private Integer idTransaccion;
	private String  descTransaccion;
	private Integer idProducto;
	private String descProducto;
	private Integer idCanal;
	private String descCanal;
	private Integer idInstitucionEmisora;
	private String descInstitucionEmisora;
	private Integer idInstitucionReceptora;
	private String descInstitucionReceptora;
	private String idProceso;
	private String descProceso;
	private String idBin;
	private String descBin;

	private String idMembresia;
	private String descMembresia;
	private String idServicio;
	private String descServicio;
	private Integer idOrigen;
	private String descOrigen;
}
