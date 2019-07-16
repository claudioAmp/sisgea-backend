package ob.unibanca.sicf.generadorconsultas.model.criterio;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaConjuntoCampo {
	private List<Integer> listaCampo;
	private List<Integer> listaTabla;
}
