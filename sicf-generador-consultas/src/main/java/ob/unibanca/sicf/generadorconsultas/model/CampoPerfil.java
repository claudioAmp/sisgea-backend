package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampoPerfil{
	Integer idPerfilRepCampo;
	Integer idPerfil;
	String perfil;
	Integer idTabla;
	String tabla;
	Integer idCampo;
	String campo;
	Boolean existePermiso;
}
