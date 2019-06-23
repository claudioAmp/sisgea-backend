package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campo {
	private int idTabla;
    private String tabla;
	private int idCampo;
	private String campo;
	private String alias;
	private String idTipoDato;
	private int idTablaFk;
	private int truncable;
	private String llaveAsociada;
}
