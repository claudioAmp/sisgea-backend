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
	private int idOperador;
	private String idTipoDato;
	private int idTipoOperador;
    private String tipoDato;
	private String simboloOperador;
	private String operador;
	private String tipoOperador;
}
