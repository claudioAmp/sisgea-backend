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
public class IncomingVisaTC5TCR4 {
	private Integer idSecuenciaIncoming;
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
