package edu.taller.sisgea.generadorconsultas.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperadoresTipoDato {
	String idTipoDato;
	List<Operador> listaOperadores;
}
