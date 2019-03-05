package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultitabDet {
	
	@IdNumerico(maxRange = 999, groups = IRegistro.class)
	private int idMultitabCab;
	@IdCadena(maxLength = 4, regexpPattern = "[0-9]+", groups = IRegistro.class)
	private String idMultitabDet;
	@CaracterRequerido(maxLength = 50)
	private String descripcionItem;
	@CaracterRequerido(maxLength = 10)
	private String abreviatura;
	private String descripcionMultitabCab;

}