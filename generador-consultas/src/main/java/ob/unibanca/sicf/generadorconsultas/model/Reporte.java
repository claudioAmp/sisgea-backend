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
public class Reporte {
	private int idReporte;
    private String nombre;
    private String descripcion;
    private String desc_corta;
    private String queryReporte;
	private int frecuencia;
	private List<TablaQuery> tablas;
}
