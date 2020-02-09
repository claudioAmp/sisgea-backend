package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventosVisa {
	String idBillingLineVisa;
	String serviceDescription;
	String detailedDescription;
	Integer idFormatGroupVisa;
	String descripcionFormatGroupVisa;
	Integer idRateTypeVisa;
	String descripcionRateTypeVisa;
}
