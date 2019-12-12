package ob.unibanca.sicf.consultasgenerales.model.swdmplog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxnSwdmplog {
	
	private String idMovTxnSwdmplog;
	private String messageType;
	private String stfwdIndicator;
	@TruncarPAN
	private String pan;
	private String processingCode;
	private String descripcionCodProcSw;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date transmissionDate;
	private String transmissionTime;
	private String traceNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date localTransactionDate;
	private String localTransactionTime;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date captureDate;
	private String merchantType;
	private String descripcionGiroNegocio;
	private String posEntryMode;
	private String posConditionCode;
	private String authorizationCode;
	private Integer responseCode;
	private String descripcionCodigoRptaSw;
	private String cardAcceptorLocation;
	private Integer transactionCurrency;
	private String descripcionMoneda;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private Double transactionAmount;
	private String idMembresia;
	private String descripcionMembresia;
	private String idServicio;
	private String descripcionServicio;
	private Integer idCanal;
	private String descripcionCanal;
	private Integer idInstitucionEmisora;
	private String descripcionInstEmisora;
	private Integer idInstitucionReceptora;
	private String descripcionInstReceptora;
	private String idProceso;
	private String descripcionProceso;
	private String idBin;
	private String descripcionBin;

	private Integer idOrigen;
	private String descripcionOrigen;
	private Integer idClaseTransaccion;
	private String descripcionClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
	private String estadoTransaccion;
	private String descripcionEstadoTransaccion;
}
