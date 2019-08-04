package ob.unibanca.sicf.consultasgenerales.model.bulkfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Bulkfile {
	Long idBulkFileMc;
	String messageTypeInd;
	String descripcionMessageTypeInd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
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
	Integer idEmisor;
	String descripcionEmisor;
	Integer idReceptor;
	String descripcionReceptor;
	Integer currencyCodeTran;
	String descripcionCurrencyCodeTran;
	double amountTransactionLoc;
	double accessFeeLoc;
	String accessFeeLocInd;
	Integer currencyCodeSett;
	String descripcionCurrencyCodeSett;
	String posEntry;
	String modEntradaPos;//
	String descripcionModEntradaPos;
	String capacidadEntradaPin;//
	String descripcionCapacidadEntradaPin;//
	double amountSettlement;
	String amountSettlementInd;
	double interchangeFee;
	String interchangeFeeInd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
}
