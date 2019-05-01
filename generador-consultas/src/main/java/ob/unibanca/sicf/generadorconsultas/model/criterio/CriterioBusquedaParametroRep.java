package ob.unibanca.sicf.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaParametroRep{
	
	String tipoDatoValor;
	String idParametro;
}
