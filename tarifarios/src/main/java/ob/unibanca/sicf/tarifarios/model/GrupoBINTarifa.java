package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrupoBINTarifa {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idGrupoBIN;
	@IdCadena(maxLength = 11, groups = IRegistro.class)
	private String idBIN;
	private String descripcionBIN;

}
