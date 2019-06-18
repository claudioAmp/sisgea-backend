package ob.unibanca.sicf.consultasgenerales.model.swdmplog;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxnSwdmplog {
	
	private Integer idMovTxnSwdmplog;
	private String messageType;
	private String stfwdIndicator;
	private String pan;
	private String processingCode;
	private String descripcionCodProcSw;
	private Date transmissionDate;
	private String transmissionTime;
	private String traceNumber;
	private Date localTransactionDate;
	private String localTransactionTime;
	private Date captureDate;
	private String merchantType;
	private String descripcionGiroNegocio;
	private String posEntryMode;
	private String posConditionCode;
	private double settAmountTxnFee;
	private String authorizationCode;
	private Integer responseCode;
	private String descripcionCodigoRptaSw;
	private String cardAcceptorLocation;
	private Integer transactionCurrency;
	private String descripcionMoneda;
	private Date fechaProceso;
	
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
	private Integer idRol;
	private String descripcionRolTransaccion;
	private String idBin;
	private String descripcionBin;
	
}
