package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Moneda {
	
	@IdNumerico(maxRange = 999, groups = IRegistro.class)
	private Integer idMoneda;
	@CaracterRequerido(maxLength = 20)
	private String descripcionMoneda;
	@CaracterRequerido(maxLength = 3)
	private String abreviatura;

}
