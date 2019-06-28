package ob.unibanca.sicf.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaTablaQuery{
	int idReporte;
	int idTabla;
	int idTablaQuery;
	int permited;
	String usuario;
}
