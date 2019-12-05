package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiberacionMarca {
	
	@IdCadena(maxLength = 1)
	private String idMembresia;
	private String descripcionMembresia;
	@IdNumerico(maxRange = 99)
	private Integer idProducto;
	private String descripcionProducto;
	@IdCadena(maxLength = 2)
	private String idProceso;
	private String descripcionProceso;
	private Integer diasLiberacion;
	
}
