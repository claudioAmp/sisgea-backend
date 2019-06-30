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
public class IncomingVisaTC10TCR0Det {
	Integer secuenciaIncoming;
	Date fechaProceso;
	String transactionCode;
	String descTransactionCode;
	String transCodeQualifier;
	String descTransCodeQualifier;
	String destinationBin;
	String descDestinationBin;
	String sourceBin;
	String descSourceBin;
	String reasonCode;
	String descReasonCode;
	String countryCode;
	String eventDate;
	String accountNumber;
	String accountNumberExt;
	double destinationAmount;
	double destCurrencyCode;
	String descDestCurrencyCode;
	double sourceAmount;
	double sourceCurrencyCode;
	String descSourceCurrencyCode;
	String messageText;
	String settlementFlag;
	String descSettlementFlag;
	String transactionIdentifier;
	Date centralProcessingDate;
	String reimbursementAttribute;
	String descReimbursementAttribute;
}
