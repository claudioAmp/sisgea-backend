package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablasForaneas {
	Integer idRelacionTablaFk;
	int idTabla;
	String tabla;
	int idCampo;
	String campo;
	int idTablaForanea;
	String tablaForanea;
	int idCampoForaneo;
	String campoForaneo;
	int permitido;
}
