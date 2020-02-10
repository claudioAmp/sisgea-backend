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
public class Solicitante {
	
	@IdNumerico(maxRange = 65535, groups = IRegistro.class)
	private Integer idSolicitante;
	private Integer dni;
	@CaracterRequerido(maxLength = 40)
	private String nombres;
	@CaracterRequerido(maxLength = 40)
	private String apellidoPaterno;
	@CaracterRequerido(maxLength = 40)
	private String apellidoMaterno;
	private Integer celular;
	private String email;
	private String tipoSolicitante;
	private String descripcionTipoSolicitante;
	private Integer base;
	private String escuela;
	private String descripcionEscuela;

}
