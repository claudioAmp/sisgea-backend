package ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaOutgoingVisaTC5 {
	
	private Integer idSecuenciaOutgoing; 
	private String acquirerRefNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date purchaseDateInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date purchaseDateFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaOutgoingInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaOutgoingFin;
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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroIdSecuenciaOutgoing;
	private String filtroTransactionCode;
	private String filtroIdProducto;
	private String filtroAccountNumber;
	private String filtroAcquirerRefNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaOutgoing;
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
	private String filtroCardholderIdMethod;
	private String filtroPosEntryMode;
	private String filtroPosTerminalCapability;
	private String filtroIdBin;
	private String filtroAuthorization;
	
	//Orden
	private String ordenFechaProceso;
	private String ordenIdSecuenciaOutgoing;
	private String ordenTransactionCode;
	private String ordenIdProducto;
	private String ordenAccountNumber;
	private String ordenAcquirerRefNumber;
	private String ordenFechaOutgoing;
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
	private String ordenCardholderIdMethod;
	private String ordenPosEntryMode;
	private String ordenPosTerminalCapability;
	private String ordenIdBin;
	private String ordenAuthorizationCode;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoDestinationAmountMin;
	private Double rangoDestinationAmountMax;
	private Double rangoSourceAmountMin;
	private Double rangoSourceAmountMax;
	
}