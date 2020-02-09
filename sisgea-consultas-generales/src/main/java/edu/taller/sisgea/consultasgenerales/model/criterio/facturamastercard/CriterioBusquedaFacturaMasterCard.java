package edu.taller.sisgea.consultasgenerales.model.criterio.facturamastercard;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaFacturaMasterCard {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date billingCycleDateInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date billingCycleDateFin;
	
	private String  eventId;
    
}
