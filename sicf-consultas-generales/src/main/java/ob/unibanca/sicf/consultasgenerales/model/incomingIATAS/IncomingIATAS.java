package ob.unibanca.sicf.consultasgenerales.model.incomingIATAS;

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
public class IncomingIATAS {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date 		fechaProceso;
	String		numeroTarjeta;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date		fechaConsumo;
	String 		codigoAutorizacion;
	String		codigoEstablecimiento;
	Double		importeTransaccion;
	Integer		numeroCuotas;
	Integer 	numeroMesesDiferido;
	String		tipoDocumento;
	String 		numeroDocumento;
	String		autorizacionFee;
	Long 		idIatas;
}
