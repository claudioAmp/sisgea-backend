package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.util.pagination.request.SortModel;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisaTC10 {
	private String fechaProcesoInicio;
	private String fechaProcesoFin;

	private List<SortModel> sortModel;
	private List<String> transactionsCodes;
	private List<String> reasonsCodes;
	private List<Integer> destCurrenciesCodes;
	//Filtros:
	private String filtroSecuenciaIncoming;
	private String filtroFechaProceso;
	private String filtroDestinationBin;
	private String filtroSourceBin;
	private String filtroDestinationAmount;
	private String filtroSourceAmount;
	private String filtroSourceCurrencyCode ;
	private String filtroAccountNumber;
	private String filtroReasonCode ;
	private String filtroDestCurrencyCode ;


	//ordenamiento
	private String ordenSecuenciaIncoming;
	private String ordenFechaProceso;
	private String ordenDestinationBin;
	private String ordenSourceBin;
	private String ordenReasonCode ;
	private String ordenDestinationAmount;
	private String ordenSourceAmount;
	private String ordenSourceCurrencyCode ;	
	private String ordenAccountNumber;
	private String ordenDestCurrencyCode ;

}
