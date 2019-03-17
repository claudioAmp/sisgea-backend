package ob.unibanca.sicf.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.excel.usermodel.Campo;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetadataProcedure {
	
	private String idProceso;
	private String descripcionProceso;
	private String idProcedure;
	private String nombreProcedure;
	// Parametros del procedure que se encontrarán en el archivo Excel
	private List<Campo> parametrosProcedure;
	private String patronFechaArchivo;

}
