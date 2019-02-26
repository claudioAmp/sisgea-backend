package ob.unibanca.sicf.mantenimientosgenerales.model.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorFormularioResponse {
	
	private String codigoErrorCampo;
	private String nombreCampo;
	private String mensajeErrorCampo;
	private Object valorRechazadoCampo;
}
