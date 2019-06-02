package ob.unibanca.sicf.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaFiltro{
	int idFiltroCampo;
	int idCampoQuery;
	int idReporte;
	int idTabla;
	int idCampo;
	int idinstancia;
	/*int idOperador;
	String simboloOperador;
	String operadorLogico;
	int tipoFiltro;
	String valor;*/
}
