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
public class TxnSwdmplogDetalle {
	
	private Long idMovTxnSwdmplog;
	private String messageType;
	private String stfwdIndicator;
	private String descripcionStfwd;
	@TruncarPAN
	private String pan;
	private String processingCode;
	private String descripcionCodProcSw;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date transmissionDate;
	private String transmissionTime;
	private String traceNumber;
	private String localTransactionTime;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date localTransactionDate;
	private String expiryDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date captureDate;
	private String merchantType;
	private String descripcionGiroNegocio;
	private String posEntryMode;
	private String posConditionCode;
	private double settAmountTxnFee;
	private double settAmountProcFee;
	private String acquiringInstitution;
	private String descripcionBinInstAdq;
	private String forwardingInstitution;
	private String descripcionBinInstReenv;
	private String referenceNumber;
	private String authorizationCode;
	private Integer responseCode;
	private String descripcionCodigoRptaSw;
	private String cardAcceptorTermId;
	private String cardAcceptorLocation;
	private Integer transactionCurrency;
	private String descripcionMoneda;
	private String origMessageType;
	private String origTraceNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date origDate;
	private String origTime;
	private String origAcquiringInst;
	private String origForwardingInst;
	private String requestingInstitution;
	private String descripcionBinInstEmi;
	private String accountIdentification1;
	private String accountIdentification2;
	private String cardcategory;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private double transactionAmount;
	private String idMembresia;
	private String descripcionMembresia;
	private String idServicio;
	private String descripcionServicio;
	private Integer idOrigen;
	private String descripcionOrigen;
	private Integer idClaseTransaccion;
	private String descripcionClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
	private Integer idCanal;
	private String descripcionCanal;
	private Integer idInstitucionEmisora;
	private String descripcionInstEmisora;
	private Integer idInstitucionReceptora;
	private String descripcionInstReceptora;
	private Integer idAtm;
	private String nombreAtm;
	private String idProceso;
	private String descripcionProceso;
	private String idBin;
	private String descripcionBin;
	
	private String idOrigenArchivoConc;
	private String descripcionOrigenArchivoConc;
	private Long secuenciaOrigenConc;
	private Integer indConciliacion;
	private String descripcionConciliacion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaConciliacion;
}
