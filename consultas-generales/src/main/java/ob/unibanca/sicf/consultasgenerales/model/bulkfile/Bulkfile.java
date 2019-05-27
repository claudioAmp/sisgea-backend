package ob.unibanca.sicf.consultasgenerales.model.bulkfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Bulkfile {

	String messageTypeInd;
	String descripcionMessageTypeInd;
	String transactionDate;
	String transactionTime;
	String accountNumber;
	String processingCode;
	String descripcionProcessingCode;
	String traceNumber;
	String terminalId;
	Integer responseCode;
	String descripcionResponseCode;
	String authorizationId;
	Integer currencyCodeTran;
	Integer accessFeeLoc;
	String accessFeeLocInd;
	Integer currencyCodeSett;
	Integer amountSettlement;
	Integer interchangeFee;
	String interchangeFeeInd;
	String fechaProceso;
}
