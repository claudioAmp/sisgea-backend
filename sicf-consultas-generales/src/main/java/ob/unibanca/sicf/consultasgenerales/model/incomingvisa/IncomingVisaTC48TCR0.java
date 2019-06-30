package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTC48TCR0 {
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
	private String accountNumber;
	private String responseCode;
	private String descResponseCode;
	private Date transactionDate;
	private String transactionTime;
	private String authorizationCode;
	private String standInReasonCode;
	private String transmissionDateTime;
	private double transactionAmount;
	private String cardholderConvRate;
	private String messageType;
	private String processingCode;
	private String posConditionCode;
	private String merchantType;
	private String descMerchantType;
	private String networkIdentificationCode;
	private String reimbursementAttribute;
	private String descReimbursementAttribute;
}
