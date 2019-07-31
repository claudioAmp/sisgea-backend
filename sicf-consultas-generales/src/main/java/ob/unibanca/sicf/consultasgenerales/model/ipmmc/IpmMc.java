package ob.unibanca.sicf.consultasgenerales.model.ipmmc;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IpmMc {
	
	private String tramsKey; //
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso; //
	private String pan; //
	private String typeRecord; //falta descripcion
	private String processingCode; //no en debe estar en la grilla
	private Double amountTxn; //
	private Double amountReconcilia;
	private Double amountCardholder;
	private String acquirerReferenceData; // es el ARN
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateLocalTxn;//	
	private String timeLocalTxn; //
	private String cardhAuthenticationMethod;
	private String cardAcceptorBusinessCode;  //
	private String acquiringInstitutionIdcode;
	private String forwardingInstitutionIdcode;
	private String cardAcceptorName; //
	private String cardAcceptorCity; // no debe ir en grilla
	private String cardAcceptorCountrycode; // falta descripcion descCardAcceptorCountrycode
	private Integer currencyCodeTransaction; // falta descripcion descCurrencyCodeTransaction
	private Integer currencyCodeReconciliation;  // falta descripcion descCurrencyCodeReconciliation
	
	/* pirámide */
	private String idMembresia;
	private String descMembresia;
	private String idServicio;
	private String descServicio;
	private Integer idProducto; //
	private String descProducto; //
	private Integer idOrigen;
	private String descOrigen;
	private Integer idCanal; //
	private String descCanal; //
	private Integer idClaseTransaccion;
	private String descClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descCodigoTransaccion;
	private Integer idInstitucionEmisora; //
	private String descInstEmisora; //
	private Integer idInstitucionReceptora; //
	private String descInstReceptora; //
	private String idProceso; //
	private String descProceso; //
	private String idBin; //
	private String descBin; //
	private String idBinReceptor; //no debe en grilla
	private String descBinReceptor; //no debe en grilla
	
	//POR VER SI ALGUNAS DE LAS SIGUIENTES VA EN LA GRILLA O EN EL FILTRO DE CONSULTA
	private Integer currencyCodeCardholder;
	private String addAmountAccountType;
	private String addAmountAmountType;
	private String addAmountCurrencyCode;
	private String addAmountAmountSign;
	private Double addAmountAmount;
	private String iccSystemRelatedData;
	private String lifeCycleSupportIndicator;
	private String traceId;
	private String messageNumber;
	private String txnDestinationInstIdcode;
	private String txnOriginatorInstIdcode;
	private String receivingInstitutionIdcode;
	private Double amountCurrencyConvAssess;
	private String gcmsProductIdentifier;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date iccrEffectiveDate;
	private Integer recurringPaymentIndicator;
	private String terminalType;
	private String messageReversalIndicator;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date centralProcDateOrigMess;
	private String programRegistrationId;
	private String securityProtocol;
	private String cardholderAuthentication;
	private String ucafCollectionIndicator;
	private Integer currencyCodeOrigTxnAmount;
	private Integer currencyCodeOrigRecAmount;
	private String cardProgramIdentifier;
	private String businessServArrangeTypecode;
	private String businessServIdcode;
	private String interchangeRateDesignator;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date businessDate;
	private String businessCycle;
	private String cardAcceptorBusinessMccInd;
	private String productOverrideIndicator;
	private String corpIncentiveRateApplyInd;
	private String atmLatePresentmentIndicator;
	private String settlServTransAgentIdcode;
	private String settlServTransAgentAccount;
	private String settlServLevelcode;
	private String settlServIdcode;
	private String settlForeignExchanRateCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date reconciliationDate;
	private Integer reconciliationCycle;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date settlDate;
	private Integer settlCycle;
	private String settlIndicator;
	private String settlAgreementInformation;
	private String customerServicePhoneNumber;
	private String cardAcceptorPhoneNumber;
	private String additionalContactInformation;
	private String characterSetIndicator;
	private String cardAcceptorDescriptionData;
	private String soleProprietorName;
	private String legalCorporateName;
	private Integer dunBradstreetNumber;
	private String cardAcceptorUrl;
	private String formatNumber;
	private String phoneData;
	private String partnerIdcode;
	private Integer originatingMessageFormat;
	private Integer riskManagementApprovalCode;
	private String memberReconciliationInd1;
	
}
