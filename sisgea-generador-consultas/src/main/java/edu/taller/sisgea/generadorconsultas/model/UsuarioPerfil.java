package edu.taller.sisgea.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPerfil{
	Integer idPerfilRepUsuario;
	int idPerfil;
	String perfil;
	String usuario;
}
