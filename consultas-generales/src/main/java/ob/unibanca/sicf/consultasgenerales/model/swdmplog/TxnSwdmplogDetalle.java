package ob.unibanca.sicf.consultasgenerales.model.swdmplog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxnSwdmplogDetalle {
	
	private int idMovTxnSwdmplog;
	private String messageType;
	private String stfwdIndicator;
	private String pan;
	private String processingCode;
	private double transactionAmount;
	private Date transmissionDate;
	private String transmissionTime;
	private String traceNumber;
	private String localTransactionTime;
	private Date localTransactionDate;
	private String expiryDate;
	private Date captureDate;
	private String merchantType;
	private String posEntryMode;
	private String posConditionCode;
	private double settAmountTxnFee;
	private String acquiringInstitution;
	private String forwardingInstitution;
	private String referenceNumber;
	private String authorizationCode;
	private int responseCode;
	private String descripcionResponseCode;
	private String cardAcceptorTermId;
	private String cardAcceptorLocation;
	private int transactionCurrency;
	private String origMessageType;
	private String origTraceNumber;
	private Date origDate;
	private String origTime;
	private String origAcquiringInst;
	private String origForwardingInst;
	private String requestingInstitution;
	private String accountIdentification1;
	private String accountIdentification2;
	private String cardcategory;
	private Date fechaProceso;

}
