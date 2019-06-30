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
public class IncomingVisaTC48TCR1 {
	private Integer secuenciaIncoming;
	private Date fechaProceso;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private String cvv2Authorization;
	private String cvv2ResultCode;
	private String descCvv2ResultCode;
	private String networkIdCode;
	private String origMessageType;
	private String traceNumber;
	private String cardAcceptorName;
	private String nationalPosGeoData;
	private double amountIssuer;
	private String addressVerifData;
	private String forwardingInstId;
	private String forwInstCountryCode;
	private String fileUpdateErrorCode;
	private String pacmDiversionLevel;
	private String pacmDiversionReason;
	private String chipConditionCode;
	private String cvvResultsCode;
}
