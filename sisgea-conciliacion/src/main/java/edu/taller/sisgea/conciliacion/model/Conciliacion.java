package edu.taller.sisgea.conciliacion.model;

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
public class Conciliacion {
	
	private Integer idConciliacion;
	@CaracterRequerido(maxLength = 50)
	private String descripcionConciliacion;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idPaquete;
	private String nombrePaquete;
	@CaracterRequerido(maxLength = 50)
	private String nombreProcedimiento;
	
}
