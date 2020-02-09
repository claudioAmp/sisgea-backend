package edu.taller.sisgea.consultasgenerales.model.establecimientovisanet;

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
public class EstablecimientoVisanetComis {
	
	String idAdquirente;
	String idEstablecimiento;
	String nombreComercial;
	String idMembresia;
	String descripcionMembresia;
	Integer idProducto;
	String descripcionProducto;
	Double porcentaje;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	
}
