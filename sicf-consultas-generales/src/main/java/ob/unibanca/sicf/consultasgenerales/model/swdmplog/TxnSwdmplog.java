package ob.unibanca.sicf.consultasgenerales.model.swdmplog;

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
public class TxnSwdmplog {
	private Long idMovTxnSwdmplog;
	private String messageType;
	private String stfwdIndicator;
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
	private double transactionAmount;
	private String idMembresia;
	private String descripcionMembresia;
	private String idServicio;
	private String descripcionServicio;
	private Integer idCanal;
	private String descripcionIdCanal;
	private Integer idInstitucionEmisora;
	private String descripcionInstEmisora;
	private Integer idInstitucionReceptora;
	private String descripcionInstReceptora;
	private String idProceso;
	private String descripcionProceso;
	private String idBin;
	private String descripcionBin;
	
}
