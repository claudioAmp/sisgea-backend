package ob.unibanca.sicf.reportes.model;

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
public class Perfil {
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idPerfil;
	@CaracterRequerido(maxLength = 30)
	private String descripcion;
	private boolean activo;
}
