package ob.unibanca.sicf.generadorconsultas.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablaQuery {
	private Integer idTablaQuery;
	private int idReporte;
	private int idTabla;
    private String tabla;
	private String idInstancia;
	private int orden;
	private boolean esBase;
}
