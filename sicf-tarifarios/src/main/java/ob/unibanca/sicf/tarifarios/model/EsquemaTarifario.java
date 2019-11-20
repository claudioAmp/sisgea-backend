package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EsquemaTarifario {
	
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idEsquema;
	@CaracterRequerido(maxLength = 30)
	private String descripcionEsquema;

}
