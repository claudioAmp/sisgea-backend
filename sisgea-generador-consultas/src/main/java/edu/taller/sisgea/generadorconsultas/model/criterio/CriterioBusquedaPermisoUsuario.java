package edu.taller.sisgea.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaPermisoUsuario{
	
	String perfil;
	int idPerfil;
	int idTabla;
	int idCampo;
	String username;
	String campo;
	String tabla;
	int permited;
	int distinct;
	
}
