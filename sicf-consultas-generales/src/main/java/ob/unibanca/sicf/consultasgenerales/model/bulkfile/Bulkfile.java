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
	Date transactionDate;
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
	String descripcionCurrencyCodeTran;
	Integer accessFeeLoc;
	String accessFeeLocInd;
	Integer currencyCodeSett;
	String descripcionCurrencyCodeSett;
	Integer amountSettlement;
	String amountSettlementInd;
	Integer interchangeFee;
	String interchangeFeeInd;
	Date fechaProceso;
}
