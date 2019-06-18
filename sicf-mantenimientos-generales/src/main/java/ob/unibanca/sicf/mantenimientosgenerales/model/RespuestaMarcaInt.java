package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaMarcaInt{
	
	private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[a-zA-Z0-9]+", groups = IRegistro.class)
	private String idRespuesta;
	@CaracterRequerido(maxLength = 150)
	private String descripcionRespuesta;

}