package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EscenarioTarifa {
	
	private int idInstitucion;
	private String descripcionInstitucion;
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
	private int idTarifa;
	private String descripcionTarifa;
	
	private int idEscenarioTarifa;

}
