package edu.taller.sisgea.tarifarios.model;

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
public class TipoTarifa {
	
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idTarifa;
	@CaracterRequerido(maxLength = 60)
	private String descripcionTipoTarifa;
	private boolean aplicaGrupoBIN;
	private boolean aplicaDifTxn;
	private int idEsquema;
	private String descripcionEsquema;

}
