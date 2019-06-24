package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.util.pagination.EstructuraConsulta;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisaTC10 {
	private Date fechaProcesoInicio;
	private Date fechaProcesoFin;
	private List<String> transactionsCodes;
	private List<String> reasonSCodes;
	private List<Integer> destCurrenciesCodes;
	EstructuraConsulta estructuraConsulta;
	
}
