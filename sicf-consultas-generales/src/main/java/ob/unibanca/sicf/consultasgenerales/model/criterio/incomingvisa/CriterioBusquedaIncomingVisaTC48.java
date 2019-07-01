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
public class CriterioBusquedaIncomingVisaTC48 {
	private String fechaProcesoInicio;
	private String fechaProcesoFin;
	private String fechaTransaccionInicio;
	private String fechaTransaccionFin;	
	private String accountNumber;
	private List<String> standInReasonsCodes;
	private List<String> responsesCodes;
	private List<String> merchantTypes;
}
