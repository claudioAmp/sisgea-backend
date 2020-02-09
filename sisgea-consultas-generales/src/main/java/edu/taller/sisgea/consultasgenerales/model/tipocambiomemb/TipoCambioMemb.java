package edu.taller.sisgea.consultasgenerales.model.tipocambiomemb;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambioMemb {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTipoCambio;
	Double tipoCambio;
	String idMembresia;
	String descripcionMembresia;
}
