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
public class TipoDocumento {
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	Integer idDocumento;
	@CaracterRequerido(maxLength = 100)
	String descripcionTipoDocumento;
	String abreviatura;
	String codigoSunat;
}
