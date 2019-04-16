package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;
import java.util.List;
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
	private String acquirerRefNumber;
	private String fechaProcesoInicio;
	private String fechaProcesoFin;
	private String purchaseDateInicio;
	private String purchaseDateFin;
	private Integer destinationAmount;
	private String merchantName;
	private String merchantCountryCode;
	private String authorizationCode;
	
	private List<String> entriesMode;
	private List<String> floorsLimitIndication;
	private List<String> transactionsCode;
	private List<String> accountsNumber;
	private List<String> cardholdersIdMethod;
}
