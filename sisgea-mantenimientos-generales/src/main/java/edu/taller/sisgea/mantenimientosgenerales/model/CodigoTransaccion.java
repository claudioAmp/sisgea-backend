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
public class CodigoTransaccion {
	
	private Integer idClaseTransaccion;
	private String descripcionClaseTransaccion;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idCodigoTransaccion;
	@CaracterRequerido(maxLength = 100)
	private String descripcionCodigoTransaccion;
	@CaracterRequerido(maxLength = 20)
	private String descripcionCorta;
	@IdNumerico(maxRange = 99999)
	private Integer idCodigoFacturacion;
	private String descripcionCodigofacturacion;
	private boolean aplicaCompensacion;
	private boolean compensaFondos;
	private boolean compensaComisiones;
}
