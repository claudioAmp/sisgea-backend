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
public class CriterioBusquedaIncomingVisaTC5 {
	
	private Integer idSecuenciaIncoming; 
	private String acquirerRefNumber;
	private String fechaProcesoInicio;
	private String fechaProcesoFin;
	private String purchaseDateInicio;
	private String purchaseDateFin;
	private String fechaIncomingInicio;
	private String fechaIncomingFin;
	private double destinationAmount;
	private String merchantName;
	private String authorizationCode;
	private String posTerminalCapability;
	private List<String> merchantsCountryCode;
	private List<String> merchantsCategoryCode;
	private List<Integer> institucionesEmisoras;
	private List<Integer> institucionesReceptoras;
	private List<String> idsBines;
	private List<Integer> idsCanales;
	private List<String> entriesMode;
	private List<String> idsLimitesPisos;
	private List<String> transactionsCode;
	private String accountsNumber;
	private List<String> accountsNumberExt;
	private Integer destinationCurrencyCode;
	private List<String> cardholdersIdMethod;
}
