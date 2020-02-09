package edu.taller.sisgea.generadorconsultas.model.criterio;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaPerfilCampoActualizarMasivo {
	Integer idPerfil;
	List<HashMap<String,String>> listaModificacion;
	String usuario;
}
