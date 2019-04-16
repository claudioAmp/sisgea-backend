package ob.unibanca.sicf.consultasgenerales.model.swdmplog;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxnSwdmplog {
	private int idMovTxnSwdmplog;
	private String messageType;
	private Date fechaProceso;
	private Date transmissionDate;
	private String transmissionTime;
	private String authorizationCode;
	private String traceNumber;
	private int responseCode;
	private String descripcionResponseCode;
	private int transactionCurrency;
	private double transactionAmount;
	private String cardAcceptorLocation;
	private String merchantType;
	private String acquiringInstitucion;
	private String requestingInstitucion;
	private String stfwdIndicator;
	private String pan;
	private String processingCode;
	private double settlementAmount;
	private double cardIssuerAmount;
	private double convRateSettlement;
	private double convRateBilling;
	private Date localTransactionDate;
	private String localTransactionTime;
	private Date captureDate;
	private double settAmountTxnFee;
	private int cardAcceptorTermId;
	private String referenceNumber;
	private String posEntryMode;
}
