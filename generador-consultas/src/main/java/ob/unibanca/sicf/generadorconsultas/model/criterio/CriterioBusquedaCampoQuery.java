package ob.unibanca.sicf.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaCampoQuery{
	int idReporte;
	int idTabla;
	/*int idCampo;
	int idTablaFrom;
	int idCampoFrom;
	boolean enSelect;
	boolean orderBy;
	boolean enGroupBy;*/
}
