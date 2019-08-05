package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTC5TCR4 {
	
	private Long idSecuenciaIncoming;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private String businessFormatCode;
	private String networkIdCode;
	private String contactInformation;
	private String adjustmentProcessingInd;
	private String messageReasonCode;
	private Integer surchargeAmount;
	private String surchargeCreDebInd;
	private Integer surchargeAmountCbc;
	private Integer moneyTransferForeingFee;
}
