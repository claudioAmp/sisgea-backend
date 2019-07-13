package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CondicionQuery {
	private int idCondicionQuery;
	private int idCondicionPadre;
	private int idReporte;
    private String operadorLogico;
	private int tipoCondicion;
}
