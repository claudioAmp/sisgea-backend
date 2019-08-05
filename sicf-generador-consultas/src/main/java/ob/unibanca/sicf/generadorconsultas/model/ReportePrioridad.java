package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportePrioridad {
	private String usuario;
	private Integer idReporte;
    private Integer prioridad;
    private Integer idQueryUsua;
}
