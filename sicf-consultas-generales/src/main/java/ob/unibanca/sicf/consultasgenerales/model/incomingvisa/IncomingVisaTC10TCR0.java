package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

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
public class IncomingVisaTC10TCR0 {
	Long secuenciaIncoming;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	String transactionCode;
	String descTransactionCode;
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
	Integer destCurrencyCode;
	String descDestCurrencyCode;
	double sourceAmount;
	Integer sourceCurrencyCode;
	String descSourceCurrencyCode;
	String messageText;
	String settlementFlag;
	String descSettlementFlag;
	String transactionIdentifier;
	Date centralProcessingDate;
	String reimbursementAttribute;
	String descReimbursementAttribute;
}
