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
public class IncomingVisaTC10TCR0 {
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
	String accountNumber;
	String accountNumberExt;
	double destinationAmount;
	Integer destCurrencyCode;
	String descDestCurrencyCode;
	double sourceAmount;
	Integer sourceCurrencyCode;
	String descSourceCurrencyCode;
	
}
