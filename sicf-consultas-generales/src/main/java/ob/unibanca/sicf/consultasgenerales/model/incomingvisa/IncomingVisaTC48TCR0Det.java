package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import java.util.Date;

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
public class IncomingVisaTC48TCR0Det {
	private Integer secuenciaIncoming;
	private Date fechaProceso;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private String destinationBin;
	private String descDestinationBin;
	private String sourceBin;
	private String descSourceBin;
	private String formatCode; //en la bd figura varchar2(1 byte) pero en la data figura '1'
	private String constantIdentifier;
	private String accountNumber;
	private String responseCode;
	private String descResponseCode;
	private Date transactionDate;
	private String transactionTime;
	private String authorizationCode;
	private String standInReasonCode;
	private String serviceReasonCode;
	private String transmissionDateTime;
	private double transactionAmount;
	private String cardholderCurrencyCode;
	private String descCardholderCurrencyCode;
	private String txnCurrencyCode;
	private String descTxnCurrencyCode;
	private String cardholderConvRate;
	private String expirationDate; //en la bd está como varchar2
	private String acquiringInstId;
	private String descAcquiringInstId;
	private String acqInstCountrycode;
	private String descAcqInstCountrycode; //está como "nombre" en la bd, campo proveniente de la tabla MaePais
	private String messageType;
	private String processingCode;
	private String posConditionCode;
	private String merchantType;
	private String descMerchantType;
	private String posEntryMode;
	private String descPosEntryMode;
	private String posEntryCapability;
	private String descPosEntryCapability;
	private String cardAcceptorTermId;
	private String cardAcceptorId;
	private String referenceNumber;
	private String crisAlertType;
	private String crisAccountScore;
	private String networkIdentificationCode;
	private String reimbursementAttribute;
	private String descReimbursementAttribute;
}
