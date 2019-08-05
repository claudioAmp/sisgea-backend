package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IncomingVisaTC48TCR0 {
	
	private Long secuenciaIncoming;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String transactionCode;
	private String descTransactionCode;
	private String destinationBin;
	private String descDestinationBin;
	private String sourceBin;
	private String descSourceBin;
	private String formatCode;
	@TruncarPAN
	private String accountNumber;
	private String responseCode;
	private String descResponseCode;
	private String authorizationCode;
	private String standInResponseCode;
	private String descStandInResponseCode;
	private String serviceReasonCode;
	private String transmissionDateTime;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date transactionDate;
	private String transactionTime;
	private Double transactionAmount;
	private Integer cardholderCurrencyCode;
	private String descCardholderCurrencyCode;
	private Integer transactionCurrencyCode;
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
	private String merchantType;
	private String descMerchantType;
	private String posEntryMode;
	private String descPosEntryMode;
	private String posEntryCapability;
	private String descPosEntryCapability;
	private String cardAcceptorTermId;
	private String cardAcceptorId;
	private String referenceNumber;
	private String reimbursementAttribute;
	private String descReimbursementAttribute;
}
