package ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaBulkfile {
	
	List<String> messagesTypeInd;
	String fechaTransaccionInicio; // transactionDate
	String fechaTransaccion; // transactionDate
	String fechaTransaccionFin; // transactionDate
	String accountNumber;
	String traceNumber;
	List<Integer> responsesCode; // responseCode
	String fechaProcesoInicio;
	String fechaProcesoFin;
	List<Integer> currencysCodeTran;

	// Filtros

	private String filtroFechaProceso;
	private String filtroTraceNumber;
	private String filtroAccountNumber;
	private String filtroTransactionDate;
	private String filtroTransaccionTime;
	private String filtroCurrencyCodeTran;
	private String filtroProcessingCode;
	private String filtroTerminalId;
	private String filtroResponseCode;
	private String filtroAuthorizationId;
	private String filtroAccessFeeLocInd;
	private String filtroAccessFeeLoc;
	//private String filtroAmountSettlementInd;
	private String filtroCurrencyCodeSett;
	private String filtroAmountSettlement;
	private String filtroInterchangeFeeInd;
	private String filtroInterchangeFee;

	// Orden

	private String ordenFechaProceso;
	private String ordenTraceNumber;
	private String ordenAccountNumber;
	private String ordenTransactionDate;
	private String ordenTransaccionTime;
	private String ordenCurrencyCodeTran;
	private String ordenProcessingCode;
	private String ordenTerminalId;
	private String ordenResponseCode;
	private String ordenAuthorizationId;
	private String ordenAccessFeeLocInd;
	private String ordenAccessFeeLoc;
	//private String ordenAmountSettlementInd;
	private String ordenCurrencyCodeSett;
	private String ordenAmountSettlement;
	private String ordenInterchangeFeeInd;
	private String ordenInterchangeFee;

}