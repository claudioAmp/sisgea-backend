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
public class CriterioBusquedaOutgoingVisaTC10 {
	
	//Filtros de busqueda
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;
	private List<String> transactionsCodes;
	private List<String> reasonsCodes;
	private List<Integer> destCurrenciesCodes;
	
	//Filtros cabecera de grilla
	private String filtroSecuenciaOutgoing;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroEventDate;
	private String filtroMessageText;
	private String filtroDestinationBin;
	private String filtroCountryCode;
	private String filtroSourceBin;
	private String filtroDestinationAmount;
	private String filtroSourceAmount;
	private String filtroSourceCurrencyCode ;
	private String filtroAccountNumber;
	private String filtroReasonCode ;
	private String filtroDestCurrencyCode ;
	private String filtroSettlementFlag;
	private String filtroReimbursementAttribute;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroCentralProcessingDate;
	private String filtroTransactionIdentifier;
	private String filtroTransCodeQualifier;
	private String filtroTransactionCode;

	//Ordenamiento
	private String ordenSecuenciaOutgoing;
	private String ordenEventDate;
	private String ordenMessageText;
	private String ordenFechaProceso;
	private String ordenTransactionCode;
	private String ordenDestinationBin;
	private String ordenSourceBin;
	private String ordenReasonCode ;
	private String ordenDestinationAmount;
	private String ordenSourceAmount;
	private String ordenSourceCurrencyCode ;	
	private String ordenAccountNumber;
	private String ordenDestCurrencyCode ;
	private String ordenSettlementFlag;
	private String ordenReimbursementAttribute;
	private String ordenCentralProcessingDate;
	private String ordenTransactionIdentifier;
	private String ordenTransCodeQualifier;

	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoDestinationAmountMin;
	private Double rangoDestinationAmountMax;
	private Double rangoSourceAmountMin;
	private Double rangoSourceAmountMax;
}
