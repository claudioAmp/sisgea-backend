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
	long idBulkFileMc;
	String messageTypeInd;
	String descripcionMessageTypeInd;
	Date transactionDate;
	String transactionTime;
	String accountNumber;
	String processingCode;
	String idProceso;
	String descripcionProceso;
	String traceNumber;
	String terminalId;
	Integer responseCode;
	String descripcionResponseCode;
	String authorizationId;
	Integer currencyCodeTran;
	String descripcionCurrencyCodeTran;
	double amountTransactionLoc;
	double accessFeeLoc;
	String accessFeeLocInd;
	Integer currencyCodeSett;
	String descripcionCurrencyCodeSett;
	double amountSettlement;
	String amountSettlementInd;
	double interchangeFee;
	String interchangeFeeInd;
	Date fechaProceso;
}
