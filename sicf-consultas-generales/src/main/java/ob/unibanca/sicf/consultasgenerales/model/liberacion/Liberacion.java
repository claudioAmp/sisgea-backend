package ob.unibanca.sicf.consultasgenerales.model.liberacion;

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
public class Liberacion {
	
	String estadoTransaccion;
	String descripcionEstadoTransaccion;
	String messageType;
	@TruncarPAN
	String accountNumber;
	String processingCode;
	Double transactionAmount;
	Double settlementAmount;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date transmissionDate;
	String transmissionTime;
	String traceNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date captureDate;
	String posConditionCode;
	String referenceNumber;
	Integer responseCode;
	String descripcionCodigoRptaSw;
	Integer transactionCurrency;
	String descripcionMoneda;
	String accountIdentification1;
	String accountIdentification2;
	String authorizationCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaRegistro;
	String horaRegistro;
	String idMembresia;
	String descripcionMembresia;
	Integer idOrigen;
	String descripcionOrigen;
	String idProceso;
	String descripcionProceso;
	Integer idProducto;
	String descripcionProducto;
	Integer idInstitucionEmisora;
	String descripcionInstEmisora;
	Integer idInstitucionReceptora;
	String descripcionInstReceptora;
	Long secuenciaSwdmplog;
	String origenArchivo;
	String descripcionOrigenArchivo;
	Integer indConciliacion;
	String descripcionConciliacion;
	Long secuenciaOrigen;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;

	String idServicio;
	String descripcionServicio;
	Integer idClaseTransaccion;
	String descripcionClaseTransaccion;
	Integer idCodigoTransaccion;
	String descripcionCodigoTransaccion;
	
}
