package edu.taller.sisgea.generadorconsultas.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaFiltro{
	int idFiltroCampo;
	int idCampoQuery;
	int idReporte;
	int idTabla;
	int idCampo;
	int idinstancia;
	int permited;
	String usuario;
	/*int idOperador;
	String simboloOperador;
	String operadorLogico;
	int tipoFiltro;
	String valor;*/
}
