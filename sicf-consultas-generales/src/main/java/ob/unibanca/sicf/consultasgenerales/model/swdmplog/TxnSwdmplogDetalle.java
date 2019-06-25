package ob.unibanca.sicf.consultasgenerales.model.swdmplog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxnSwdmplogDetalle {
	
	private Integer idMovTxnSwdmplog;
	private String messageType;
	private String stfwdIndicator;
	private String pan;
	private String processingCode;
	private String descripcionCodProcSw;
	private Date transmissionDate;
	private String transmissionTime;
	private String traceNumber;
	private String localTransactionTime;
	private Date localTransactionDate;
	private String expiryDate;
	private Date captureDate;
	private String merchantType;
	private String descripcionGiroNegocio;
	private String posEntryMode;
	private String posConditionCode;
	private double settAmountTxnFee;
	private String acquiringInstitution;
	private String descripcionBINInstAdq;
	private String forwardingInstitution;
	private String descripcionBINIntReenv;
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
	private Date origDate;
	private String origTime;
	private String origAcquiringInst;
	private String origForwardingInst;
	private String requestingInstitution;
	private String descripcionBinInstEmi;
	private String accountIdentification1;
	private String accountIdentification2;
	private String cardcategory;
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
	private String descripcionIntReceptora;
	private Integer idATM;
	private String nombreATM;
	private String idProceso;
	private String descripcionProceso;
	private String idBIN;
	private String descripcionBIN;
	private Integer idRol;
	private String descripcionRolTransaccion;

}
