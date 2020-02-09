package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitucionTransaccion {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private Integer idInstitucion;
	private String descripcionInstitucion;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idClaseTransaccion;
	private String descripcionClaseTransaccion;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
}
