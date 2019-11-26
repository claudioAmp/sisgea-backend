package ob.unibanca.sicf.consultasgenerales.model.observada;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Observada {
	
	Long secuenciaArchivo;
	@TruncarPAN
	String numeroTarjeta;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccion;
	String horaTransaccion;
	String idProceso;
	String descripcionProceso;
	String numeroTrace;
	Double valorTransaccion;
	Integer monedaTransaccion;
	String descripcionMoneda;
	String autorizacion;
	Integer codigoRespuesta;
	String descripcionCodigoRpta;
	Double txnAmountSwitch;
	Integer txnCurrencySwitch;
	String descripcionMonedaSwitch;
	String authorizationSwitch;
	Integer responseCodeSwitch;
	String descripcionCodigoRptaSw;
	String numeroCuenta;
	Integer idCanal;
	String descripcionCanal;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaSwitch;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	String origenArchivoConciliacion;
	String descripcionOrigenArchivo;
	Integer indConciliacion;
	String descripcionConciliacion;
	Integer indRespuestaDiferencia;
	Integer indMonedaDiferencia;
	Double valorDiferencia;
	
}
