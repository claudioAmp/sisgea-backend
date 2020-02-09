package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
	private String idPais;
	private String codigoIso3;
	private String nombre;
	private String continente;
	private Integer monedaIso;
	}
