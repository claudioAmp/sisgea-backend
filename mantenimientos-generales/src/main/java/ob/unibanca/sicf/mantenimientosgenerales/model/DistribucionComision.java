package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistribucionComision {
	
	private int idDistribucionComision;
	private String idMembresia;
	private String descripcionMembresia;
	private String idServicio;
	private String descripcionServicio;
	private int idOrigen;
	private String descripcionOrigen;
	private int idClaseTransaccion;
	private String descripcionClaseTransaccion;
	private int idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
	private int idTipoComision;
	private String descripcionTipoComision;
	private int idCuentaCargo;
	private String descripcionCuentaCargo;
	private int idCuentaAbono;
	private String descripcionCuentaAbono;

}
