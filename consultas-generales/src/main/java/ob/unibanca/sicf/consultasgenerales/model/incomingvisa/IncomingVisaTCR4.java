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
public class IncomingVisaTCR4 {
	private int idSecuenciaIncoming;
	private String BusinessFormatCode;
	private String NetworkIdCode;
	private String ContactInformation;
	private String AdjustmentProcessingInd;
	private String MessageReasonCode;
	private Integer SurchargeAmount;
	private String SurchargeCreDebInd;
	private Integer SurchargeAmountCbc;
	private Integer MoneyTransferForeingFee;
	private Date FechaProceso;
}
