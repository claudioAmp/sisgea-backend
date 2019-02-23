package ob.unibanca.sicf.mantenimientosgenerales.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametroMantenimiento {
	
	private String modo;
	private Object objetoMantenido;
	private String usuario;
}
