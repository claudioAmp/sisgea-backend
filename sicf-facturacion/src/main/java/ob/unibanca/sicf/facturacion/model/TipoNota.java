package ob.unibanca.sicf.facturacion.model;

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
public class TipoNota {
	@IdNumerico(maxRange = 9, groups = IRegistro.class)
	Integer idOrigenNota;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	Integer idNota;
	@CaracterRequerido(maxLength = 100)
	String descripcionTipoNota;
}
