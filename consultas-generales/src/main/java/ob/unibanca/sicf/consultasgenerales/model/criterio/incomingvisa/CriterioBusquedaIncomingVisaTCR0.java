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
	private String merchantCategoryCode;
	private String authorizationCode;
	private String posTerminalCapability;
	private List<Integer> institucionEmisora;
	private List<Integer> institucionReceptora;
	private List<String> idBin;
	private List<Integer> idOrigen;
	private List<String> entriesMode;
	private List<String> floorsLimitIndication;
	private List<String> transactionsCode;
	private List<String> accountsNumber;
	private List<String> accountsNumberExt;
	private List<String> destCurrencyCode;
	private List<String> cardholdersIdMethod;
}
