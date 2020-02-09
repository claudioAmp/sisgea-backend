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
public class Origen {
	
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idOrigen;
	@CaracterRequerido(maxLength = 30)
   private String descripcionOrigen;
   
}
