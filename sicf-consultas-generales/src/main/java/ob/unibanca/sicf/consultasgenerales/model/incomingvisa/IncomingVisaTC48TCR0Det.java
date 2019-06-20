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
	private String transCodeQualifier;
	private String destinationBin;
	private String sourceBin;
	private String formatCode;
	private String constantIdentifier;
	private String accountNumber;
	private String responseCode;
	private Date transactionDate;
	private String transactionTime;
	private String authorizationCode;
	private String standInReasonCode;
	private String serviceReasonCode;
	private String transmissionDateTime;
	private double transactionAmount;
	private String cardholderCurrencyCode;
	private String transactionCurrencyCode;
	private String cardholderConvRate;
	private String expirationDate;
	private String acquiringInstId;
	private String acqInstCountryCode;
	private String messageType;
	private String processingCode;
	private String posConditionCode;
	private String merchantType;
	private String posEntryMode;
	private String posEntryCapability;
	private String cardAcceptorTermId;
	private String cardAcceptorId;
	private String referenceNumber;
	private String crisAlertType;
	private String crisAccountScore;
	private String networkIdentificationCode;
	private String reimbursementAttribute;
}
