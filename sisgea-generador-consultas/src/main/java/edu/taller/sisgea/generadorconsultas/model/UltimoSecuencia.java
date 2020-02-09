package edu.taller.sisgea.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UltimoSecuencia {
	private Integer valor;
    private String claseSecuencia;
 
}
