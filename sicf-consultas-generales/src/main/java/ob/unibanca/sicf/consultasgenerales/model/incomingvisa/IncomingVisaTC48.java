package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTC48 {
	private Long secuenciaIncoming;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String destinationBin;
	private String descDestinationBin;
	private String sourceBin;
	private String descSourceBin;
	private String accountNumber;
	private String responseCode;
	private String descResponseCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
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
