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
	int idPerfil;
	String perfil;
	int idTabla;
	String tabla;
	int idCampo;
	String campo;
}
