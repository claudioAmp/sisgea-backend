package edu.taller.sisgea.consultasgenerales.model.criterio.paginacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Columna {
	private String name;
	private String order;
	private String search;
}
