package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermisoUsuario{
	private int idPermisoUsuario;
	private int idPerfilRepCampo;
	private int idPerfilRepUsuario;
	private int idUsuario;
	private String usuario;
	private int idPerfil;
	private String perfil;
	private int idTabla;
	private String tabla;
	private int idCampo;
	private String campo;
	private boolean verTruncado;
}