package ob.unibanca.sicf.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetadataProcedure {
	
	private String idProceso;
	private String descripcionProceso;
	private String idProcedure;
	private String nombreProcedure;
	private boolean esReproceso;
	private String patronFechaArchivo;

}
