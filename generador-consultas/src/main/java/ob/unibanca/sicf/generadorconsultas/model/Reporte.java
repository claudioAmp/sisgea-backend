package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
	private int idReporte;
    private String nombre;
    private String descripcion;
    private String descCorta;
    private String queryReporte;
	private int frecuencia;
}
