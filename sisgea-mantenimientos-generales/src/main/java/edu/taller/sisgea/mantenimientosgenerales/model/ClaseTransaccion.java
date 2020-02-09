package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterNoRequerido;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClaseTransaccion {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private Integer idClaseTransaccion;
	@CaracterRequerido(maxLength = 50)
	private String descripcionClaseTransaccion;
	@CaracterNoRequerido(maxLength = 2)
	private String tipoTransaccion;
}
