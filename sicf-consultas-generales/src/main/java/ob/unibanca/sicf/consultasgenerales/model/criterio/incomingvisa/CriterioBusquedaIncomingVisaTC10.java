package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.util.pagination.EstructuraConsulta;
import ob.unibanca.sicf.consultasgenerales.util.pagination.filter.ColumnFilter;
import ob.unibanca.sicf.consultasgenerales.util.pagination.request.SortModel;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisaTC10 {
	private String fechaProcesoInicio;
	private String fechaProcesoFin;
	//private List<ColumnFilter> filtro;
	private List<SortModel> sortModel;
	private List<String> transactionsCodes;
	private List<String> reasonsCodes;
	private List<Integer> destCurrenciesCodes;
	
	//Filtros:
	private String filtroSecuenciaIncoming;
	private String filtroFechaProceso ;
	private String filtroDestinationBin;
	private String filtroSourceBin;
	private String filtroReasonCode ;
	private String filtroDestinationAmount;
	private String filtroSourceAmount;
	private String filtroSourceCurrencyCode ;

}
