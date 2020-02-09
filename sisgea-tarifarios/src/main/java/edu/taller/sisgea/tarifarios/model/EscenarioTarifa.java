package edu.taller.sisgea.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EscenarioTarifa {
	
	private int idEscenarioTarifa;
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idInstitucion;
	private String descripcionInstitucion;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private String idMembresia;
	private String descripcionMembresia;
	@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]", groups = IRegistro.class)
	private String idServicio;
	private String descripcionServicio;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idOrigen;
	private String descripcionOrigen;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private int idClaseTransaccion;
	private String descripcionClaseTransaccion;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private int idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idTarifa;
	private String descripcionTipoTarifa;

}
