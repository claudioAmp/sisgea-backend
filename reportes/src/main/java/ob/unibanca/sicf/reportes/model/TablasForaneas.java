package ob.unibanca.sicf.reportes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablasForaneas {
	int idTabla;
	String tabla;
	int idTablaForanea;
	String tablaForanea;
	int idCampoFk;
	String campoFk;
}
