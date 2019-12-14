package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventosTransaccionMastercard {
	String idEventoMc;
	String description;
	Integer idClaseTransaccion;
	String descripcionClaseTransaccion;
	Integer idCodigoTransaccion;
	String descripcionCodigoTransaccion;
	//No existe este campo de abajo en vista
	Integer indAlicuota;
}
