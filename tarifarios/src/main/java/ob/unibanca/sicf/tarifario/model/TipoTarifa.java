package ob.unibanca.sicf.tarifario.model;

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
public class TipoTarifa {
	
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idTarifa;
	@CaracterRequerido(maxLength = 60)
	private String descripcion;
	@IdNumerico(maxRange = 9, groups = IRegistro.class)
	private int aplicaGrupoBIN;
	@IdNumerico(maxRange = 9, groups = IRegistro.class)
	private int aplicaDifTxn;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idEsquema;
	
}
