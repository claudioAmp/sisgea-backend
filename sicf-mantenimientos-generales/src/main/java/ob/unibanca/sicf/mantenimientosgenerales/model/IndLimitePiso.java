package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndLimitePiso {
	
	private String idMembresia;
	private String idLimitePiso; 
	private String descripcionMembresia;
	private String descripcion;
	 

}
