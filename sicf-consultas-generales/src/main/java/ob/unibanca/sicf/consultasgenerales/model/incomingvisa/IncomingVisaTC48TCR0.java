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
public class IncomingVisaTC48TCR0 {
	private Long secuenciaIncoming;
	private Date fechaProceso;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private String destinationBin;
	private String descDestinationBin;
	private String sourceBin;
	private String descSourceBin;
	private String formatCode;
	private String constantIdentifier;
	private String accountNumber;
	private String responseCode;
	private String descResponseCode;
	private Date transactionDate;
	private String transactionTime;
	private String authorizationCode;
	private String standInReasonCode;
	private String descStandInReasonCode;
	private String serviceReasonCode;
	private String transmissionDateTime;
	private double transactionAmount;
	private String cardholderCurrencyCode;
	private String descCardholderCurrencyCode;
	private String transactionCurrencyCode;
	private String descTransactionCurrencyCode;
	private String cardholderConvRate;
	private String expirationDate;
	private String acquiringInstId;
	private String descAcquiringInstId;
	private String acqInstCountryCode;
	private String descAcqInstCountryCode;
	private String messageType;
	private String processingCode;
	private String posConditionCode;
	private String descPosConditionCode;
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
