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
	String transCodeQualifier;
	String destinationBin;
	String sourceBin;
	String reasonCode;
	String countryCode;
	String eventDate;
	String accountNumber;
	String accountNumberExt;
	double destinationAmount;
	double destCurrencyCode;
	double sourceAmount;
	double sourceCurrencyCode;
	String messageText;
	String settlementFlag;
	String transactionIdentifier;
	Date centralProcessingDate;
	String reimbursementAttribute;
}
