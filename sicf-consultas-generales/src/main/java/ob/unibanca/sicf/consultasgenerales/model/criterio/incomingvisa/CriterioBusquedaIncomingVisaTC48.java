package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisaTC48 {
	private Date fechaProcesoInicio;
	private Date fechaProcesoFin;
	private List<String> transactionsCodes;
}
