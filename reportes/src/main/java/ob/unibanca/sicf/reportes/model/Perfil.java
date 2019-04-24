package ob.unibanca.sicf.reportes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {
	private int idPerfilRep;
	private String descripcionPerfilRep;
	private boolean activo;
}
