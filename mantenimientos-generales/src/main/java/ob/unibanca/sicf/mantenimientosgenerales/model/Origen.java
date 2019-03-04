package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Origen {
	
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idOrigen;
	@CaracterRequerido(maxLength = 30)
   private String descripcionOrigen;
   
}
