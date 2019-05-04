package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablaQuery {
	private int idReporte;
	private int idTabla;
    private String tabla;
	private String instancia;
	private int orden;
}
