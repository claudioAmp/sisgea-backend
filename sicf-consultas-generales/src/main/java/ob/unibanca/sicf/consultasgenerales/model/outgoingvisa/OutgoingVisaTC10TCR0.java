package ob.unibanca.sicf.consultasgenerales.model.outgoingvisa;

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
public class OutgoingVisaTC10TCR0 {
	
	String secuenciaOutgoing;
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
	@TruncarPAN
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
