package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTC48 {
	private Integer secuenciaIncoming;
	private Date fechaProceso;
	private String destinationBin;
	private String descDestinationBin;
	private String sourceBin;
	private String descSourceBin;
	private String accountNumber;
	private String responseCode;
	private String descResponseCode;
	private Date transactionDate;
	private String transactionTime;
	private String standInReasonCode;
	private String descStandInReasonCode;
	private String transmissionDateTime;
	private double transactionAmount;
	private String transactionCurrencyCode;
	private String descTransactionCurrencyCode;
	private String descTxnCurrencyCode;
	private String merchantType;
	private String descMerchantType;
}
