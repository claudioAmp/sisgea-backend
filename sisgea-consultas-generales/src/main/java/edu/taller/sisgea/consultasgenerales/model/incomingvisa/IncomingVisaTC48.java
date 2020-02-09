package edu.taller.sisgea.consultasgenerales.model.incomingvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTC48 {
	
	private String secuenciaIncoming;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String destinationBin;
	private String descDestinationBin;
	private String sourceBin;
	private String descSourceBin;
	@TruncarPAN
	private String accountNumber;
	private String responseCode;
	private String descResponseCode;
	private String standInResponseCode;
	private String descStandInResponseCode;
	private String transmissionDateTime;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date transactionDate;
	private String transactionTime;
	private Double transactionAmount;
	private Integer transactionCurrencyCode;
	private String descTransactionCurrencyCode;
	private String merchantType;
	private String descMerchantType;
}
