package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisa {
	Integer idSecuenciaIncoming;
	String fechaProceso;
}
