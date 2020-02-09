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
public class CampoMatching {
	
	private Integer idCampoMatching;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idConcTabla;
	private String nombreProcedimiento;
	@CaracterRequerido(maxLength = 4000)
	private String campoArchivoConcA;
	@CaracterRequerido(maxLength = 4000)
	private String campoArchivoConcB;
	@IdNumerico(maxRange = 9)
	private Integer tipoRango;
	@CaracterRequerido(maxLength = 50, regexpPattern = "[0-9]+")
	private String rangoLimInferior;
	@CaracterRequerido(maxLength = 50, regexpPattern = "[0-9]+")
	private String rangoLimSuperior;
	
}
