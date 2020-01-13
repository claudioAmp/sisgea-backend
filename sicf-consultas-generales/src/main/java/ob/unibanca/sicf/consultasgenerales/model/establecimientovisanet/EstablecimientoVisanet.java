package ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstablecimientoVisanet {
	
	String idAdquirente;
	String idEstablecimiento;
	String ruc;
	String razonSocial;
	String nombreComercial;
	String idGiro;
	String descripcionGiroNegocio;
	String direccion;
	String ubigeo;
	String recurrente;
	String descripcionRecurrente;
	String tipoFacturacion;
	String descripcionTipoFacturacion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	
}
