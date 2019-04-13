package ob.unibanca.sicf.consultasgenerales.model.criterio;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisaTCR0 {
	private Integer idSecuenciaIncoming;
	/*private String transactionCode;
	private String[] accountNumber;
	private String acquirerRefNumber;
	private Date purchaseDate;
	private Integer destinationAmount;
	private String merchantName;
	private String merchantCountryCode;
	private String authorizationCode;
	private String[] entryMode*/;
}
