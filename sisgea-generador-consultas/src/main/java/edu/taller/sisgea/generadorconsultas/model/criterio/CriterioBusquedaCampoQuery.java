package edu.taller.sisgea.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaCampoQuery{
	int idCampoQuery;
	int idTablaQuery;
	int idReporte;
	int idTabla;
	int idCampo;
	int idTablaFrom;
	String idInstanciaTablaFrom;
	int idCampoFrom;
	int permited;
	String usuario;
	/*int idCampo;
	int idTablaFrom;
	int idCampoFrom;
	boolean enSelect;
	boolean orderBy;
	boolean enGroupBy;*/
}
