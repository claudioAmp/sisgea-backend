package edu.taller.sisgea.consultasgenerales.model.criterio.outgoingvisa;

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
public class CriterioBusquedaOutgoingVisa {
	String idSecuenciaOutgoing;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
}
