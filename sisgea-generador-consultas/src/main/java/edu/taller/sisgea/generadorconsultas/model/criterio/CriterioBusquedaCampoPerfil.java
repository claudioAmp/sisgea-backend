package edu.taller.sisgea.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaCampoPerfil{
	String perfil;
	int idTabla;
	int idPerfil;
	int idCampo;
	int idPerfilRepCampo;
}
