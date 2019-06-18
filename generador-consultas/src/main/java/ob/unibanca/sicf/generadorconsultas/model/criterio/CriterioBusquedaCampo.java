package ob.unibanca.sicf.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaCampo{
	int idTabla;
	private int idCampo;
	String campo;
	String tabla;
	int truncable;
	int idPerfil;
	String usuario;
}
