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
public class IncomingVisaTC48TCR1 {
	
	private String secuenciaIncoming;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String cvv2Authorization;
	private String cvv2ResultCode;
	private String descCvv2ResultCode;
	private String networkIdCode;
	private String origMessageType;
	private String traceNumber;
	private String cardAcceptorName;
	private String nationalPosGeoData;
	private Double amountIssuer;
	private String addressVerifData;
	private String forwardingInstId;
	private String forwInstCountryCode;
	private String fileUpdateErrorCode;
	private String pacmDiversionLevel;
	private String pacmDiversionReason;
	private String chipConditionCode;
	private String cvvResultsCode;
}
