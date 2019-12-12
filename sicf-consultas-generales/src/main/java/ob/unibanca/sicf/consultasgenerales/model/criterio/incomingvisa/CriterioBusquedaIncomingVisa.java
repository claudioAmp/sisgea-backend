package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisa {
	Long idSecuenciaIncoming;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
}
