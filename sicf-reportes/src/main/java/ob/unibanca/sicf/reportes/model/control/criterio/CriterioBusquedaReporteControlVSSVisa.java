package ob.unibanca.sicf.reportes.model.control.criterio;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.reportes.model.control.ReporteControlVSSVisa;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaReporteControlVSSVisa {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	List<ReporteControlVSSVisa> resultado;
}
