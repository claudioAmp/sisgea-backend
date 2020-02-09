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
public class CampoInsertarObservada {
	
	private Integer idCmpInsObservada;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idConcTabla;
	private String nombreProcedimiento;
	@CaracterRequerido(maxLength = 50)
	private String campoTxnObservada;
	@CaracterRequerido(maxLength = 4000)
	private String campoInsertar;
	@CaracterRequerido(minLength = 2, maxLength = 2, regexpPattern = "^[0-9]{2}")
	private String idOrigenArchivo;
	private String descripcionOrigenArchivo;
	
}
