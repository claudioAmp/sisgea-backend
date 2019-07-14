package ob.unibanca.sicf.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaTablasForaneas {
	String idTabla;
	String tablaForanea;
	int permited;
	String usuario;
	Integer idRelacionTablaFk;
}
