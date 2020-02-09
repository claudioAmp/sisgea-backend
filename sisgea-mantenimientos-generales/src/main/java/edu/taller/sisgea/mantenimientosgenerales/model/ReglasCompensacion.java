package edu.taller.sisgea.mantenimientosgenerales.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReglasCompensacion {
	private Integer idDistribucionFondo;
	private String idMembresia;
	private String descripcionMembresia;
	private String idServicio;
	private String descripcionServicio;
	private Integer idOrigen;
	private String descripcionOrigen;
	private Integer idClaseTransaccion;
	private String descripcionClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
	private Integer idCuentaCargoFondo;
	private String descripcionCuentaCargoFondo;
	private Integer idCuentaAbonoFondo;
	private String descripcionCuentaAbonoFondo;
	private List<ReglasCompensacionComision> comisiones;
}
