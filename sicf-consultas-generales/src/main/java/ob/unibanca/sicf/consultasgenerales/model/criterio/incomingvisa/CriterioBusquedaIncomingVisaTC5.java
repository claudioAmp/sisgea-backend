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
	private List<Integer> destinationCurrencyCode;
	private List<String> cardholdersIdMethod;
	
	//filtros
	private String filtroFechaProceso;
	private String filtroIdSecuenciaIncoming;
	private String filtroTransactionCode;
	private String filtroIdProducto;
	private String filtroAccountNumber;
	private String filtroAcquirerRefNumber;
	private String filtroFechaIncoming;
	private String filtroPurchaseDate;
	private String filtroSourceCurrencyCode;
	private String filtroSourceAmount;
	private String filtroDestCurrencyCode;
	private String filtroDestinationAmount;
	private String filtroMerchantName;
	private String filtroMerchantCity;
	private String filtroMerchantCountryCode;
	private String filtroMerchantCategoryCode;
	private String filtroInstitucionEmisora;
	private String filtroInstitucionReceptora;
	private String filtroIdCanal;
	
	//Orden
	private String ordenFechaProceso;
	private String ordenIdSecuenciaIncoming;
	private String ordenTransactionCode;
	private String ordenIdProducto;
	private String ordenAccountNumber;
	private String ordenAcquirerRefNumber;
	private String ordenFechaIncoming;
	private String ordenPurchaseDate;
	private String ordenSourceCurrencyCode;
	private String ordenSourceAmount;
	private String ordenDestCurrencyCode;
	private String ordenDestinationAmount;
	private String ordenMerchantName;
	private String ordenMerchantCity;
	private String ordenMerchantCountryCode;
	private String ordenMerchantCategoryCode;
	private String ordenInstitucionEmisora;
	private String ordenInstitucionReceptora;
	private String ordenIdCanal;
}
