package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperadorTipoDato {
	private int idTipoDato;
    private String tipoDato;
	private int idOperador;
	private String simboloOperador;
	private String operador;
	private int idTipoOperador;
	private String tipoOperador;
}
