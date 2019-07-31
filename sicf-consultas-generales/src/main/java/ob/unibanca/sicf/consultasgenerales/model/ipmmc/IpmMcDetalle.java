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
	private String recSeqNbr;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String indProceso;
	private String pan;
	private String typeRecord;
	private String processingCode;
	private Double amountTxn;
	private Double amountReconcilia;
	private Double amountCardholder;
	private Double amountIccr;
	private Double conversionRateReconcilia;
	private Double conversionRateCardholder;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateLocalTxn;
	private String timeLocalTxn;
	private String cardDataInputCapability;
	private String cardhAuthenticCapability;
	private String cardCaptureCapability;
	private String terminalOperatingEnvironment;
	private String cardholderPresentData;
	private String cardPresentData;
	private String cardDataInputMode;
	private String cardhAuthenticationMethod;
	private String cardhAuthenticationEntity;
	private String cardDataOutputCapability;
	private String terminalDataOutCapability;
	private String pinCaptureCapability;
	private String cardSequenceNumber;
	private String functionCode;
	private String messageReasonCode;
	private String cardAcceptorBusinessCode;
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
	private Integer currencyCodeTransaction;
	private Integer currencyCodeReconciliation;
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
	
	/* pirámide */
	private String idMembresia;
	private String descMembresia;
	private String idServicio;
	private String descServicio;
	private Integer idProducto;
	private String descProducto;
	private Integer idOrigen;
	private String descOrigen;
	private Integer idCanal;
	private String descCanal;
	private Integer idClaseTransaccion;
	private String descClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descCodigoTransaccion;
	private Integer idInstitucionEmisora;
	private String descInstEmisora;
	private Integer idInstitucionReceptora;
	private String descInstReceptora;
	private String idProceso;
	private String descProceso;
	private String idBin;
	private String descBin;
	private String idBinReceptor;

}
