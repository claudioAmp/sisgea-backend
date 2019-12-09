package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventosInstitucionVisa {
	String idBillingLineVisa;
	String serviceDescription;
	Integer idInstitucion;
	String descripcionInstitucion;
	//Comodin para registro masivo
	String eventosSeparadosPorComas;
}
