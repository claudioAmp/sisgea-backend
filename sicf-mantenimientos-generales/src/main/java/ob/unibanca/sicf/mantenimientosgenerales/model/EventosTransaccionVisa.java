package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventosTransaccionVisa {
	String idBillingLineVisa;
	String serviceDescription;
	String detailedDescription;
	Integer idFormatGroupVisa;
	String descripcionFormatGroupVisa;
	Integer idRateTypeVisa;
	String descripcionRateTypeVisa;
	Integer idClaseTransaccion;
	String descripcionClaseTransaccion;
	Integer idCodigoTransaccion;
	String descripcionCodigoTransaccion;
	Integer indAlicuota;
}