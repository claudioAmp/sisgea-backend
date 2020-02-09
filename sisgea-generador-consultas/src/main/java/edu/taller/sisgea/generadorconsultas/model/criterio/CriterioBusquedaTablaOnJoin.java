package edu.taller.sisgea.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaTablaOnJoin{
	Integer idTablaOnJoin;
	int idReporte;
	int idCampoQueryBase;
	int idTablaBase;
	int idCampoQueryJoin;
	int idTablaJoin;
	/*int idOperador;
	String simboloOperador;
	String operadorLogico;
	int tipoFiltro;
	String valor;*/
}
