package ob.unibanca.sicf.consultasgenerales.model.ipmmc;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IpmMcDetalle {
	
	private String tramsKey;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateLocalTxn;
	private String pan;
	private String typeRecord;
	private String descTypeRecord;
	private Double amountTxn;
	private Double amountReconcilia;
	private Double amountCardholder;
	private String timeLocalTxn;
	private String cardDataInputCapability;
	private String descCardDataInputCapability;
	private String cardhAuthenticCapability;
	private String descCardhAuthenticCapability;
	private String cardCaptureCapability;
	private String descCardCaptureCapability;
	private String terminalOperatingEnvironment;
	private String descTerminalOperatingEnvironment;
	private String cardholderPresentData;
	private String descCardholderPresentData;
	private String cardPresentData;
	private String descCardPresentData;
	private String cardDataInputMode;
	private String descCardDataInputMode;
	private String cardhAuthenticationMethod;
	private String descCardhAuthenticationMethod;
	private String cardhAuthenticationEntity;
	private String descCardhAuthenticationEntity;
	private String cardDataOutputCapability;
	private String descCardDataOutputCapability;
	private String terminalDataOutCapability;
	private String descTerminalDataOutCapability;
	private String pinCaptureCapability;
	private String descPinCaptureCapability;
	private String functionCode;
	private String descFunctionCode;
	private String messageReasonCode;
	private String cardAcceptorBusinessCode;
	private String descCardAcceptorBusinessCode;
	private Double originalAmountTxn;
	private Double originalAmountReconcilia;
	private String acquirerReferenceData;
	private String acquiringInstitutionIdcode;
	private String forwardingInstitutionIdcode;
	private String retrievalReferenceNumber;
	private String approvalCode;
	private String serviceCode;
	private String cardAcceptorTerminalid;
	private String cardAcceptorIdcode;
	private String cardAcceptorName;
	private String cardAcceptorStreetAddress;
	private String cardAcceptorCity;
	private String cardAcceptorPostalZipcode;
	private String cardAcceptorStaPrvRegCode;
	private String cardAcceptorCountrycode;
	private String descCardAcceptorCountrycode;
	private Integer currencyCodeTransaction;
	private String descCurrencyCodeTransaction;
	private Integer currencyCodeReconciliation;
	private Integer currencyCodeCardholder;
	private String descCurrencyCodeCardholder;
	private String lifeCycleSupportIndicator;
	private String traceId;
	private String receivingInstitutionIdcode;
	private String terminalType;
	private String messageReversalIndicator;
	private String cardholderAuthentication;
	private Integer currencyCodeOrigTxnAmount;
	private String descCurrencyCodeOrigTxnAmount;
	private Integer currencyCodeOrigRecAmount;
	private String descCurrencyCodeOrigRecAmount;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date businessDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date reconciliationDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date settlDate;
	
	private String idMembresia;
	private String descMembresia;
	private String idServicio;
	private String descServicio;
	private Integer idTransaccion;
	private String  descIdTransaccion;
	private Integer idProducto;
	private String descProducto;
	private Integer idCanal;
	private String descCanal;
	private Integer idInstitucionEmisora;
	private String descInstitucionEmisora;
	private Integer idInstitucionReceptora;
	private String descInstitucionReceptora;
	private String idProceso;
	private String descIdProceso;
	private String idBin;
	private String descBin;

}
