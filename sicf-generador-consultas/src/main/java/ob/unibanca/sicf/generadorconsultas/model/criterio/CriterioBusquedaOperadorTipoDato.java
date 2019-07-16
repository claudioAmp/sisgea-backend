package ob.unibanca.sicf.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaOperadorTipoDato{
	private int idTipoDato;
    private String tipoDato;
	private int idOperador;
	private String simboloOperador;
	private String operador;
	private int idTipoOperador;
	private String tipoOperador;
	private String soloBinario;
}
