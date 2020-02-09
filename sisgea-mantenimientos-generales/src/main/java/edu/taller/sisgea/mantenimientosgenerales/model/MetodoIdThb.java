package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetodoIdThb {
    private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[0-9]+", groups = IRegistro.class)
	private String idMetodoIdThb;
	@CaracterRequerido(maxLength = 60)
	private String descripcionMetodoIdThb;
}
