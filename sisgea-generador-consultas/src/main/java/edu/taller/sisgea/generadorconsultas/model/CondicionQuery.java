package edu.taller.sisgea.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CondicionQuery {
	private Integer idCondicionQuery;
	private Integer idCondicionPadre;
	private int idCondicionQueryAux;
	private int idReporte;
    private String operadorLogico;
	private int tipoCondicion;
}
