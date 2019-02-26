package ob.unibanca.sicf.mantenimientosgenerales.model.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	private int codigo;
	private String mensajeUsuario;
	private String mensajeDesarrollador;
	private List<ErrorFormularioResponse> errorFormularioResponses;
}
