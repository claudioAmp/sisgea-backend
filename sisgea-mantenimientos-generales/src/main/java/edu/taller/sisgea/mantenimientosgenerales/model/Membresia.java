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
public class Membresia {
	
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private String idMembresia;
	@CaracterRequerido(maxLength = 30)
	private String descripcionMembresia;
}
