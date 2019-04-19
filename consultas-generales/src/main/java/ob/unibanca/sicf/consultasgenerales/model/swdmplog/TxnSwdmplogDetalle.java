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
	
	private int idMovTxnSwdmplog;
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
	private int responseCode;
	private String descripcionCodigoRptaSw;
	private String cardAcceptorTermId;
	private String cardAcceptorLocation;
	private int transactionCurrency;
	private String descripcionMonedaTransaccion;
	private String origMessageType;
	private String origTraceNumber;
	private Date origDate;
	private String origTime;
	private String origAcquiringInst;
	private String origForwardingInst;
	private String requestingInstitution;
	private String descripcionBINInstEmi;
	private String accountIdentification1;
	private String accountIdentification2;
	private String cardcategory;
	private Date fechaProceso;
	
	private String idMembresia;
	private String descripcionMembresia;
	private String idServicio;
	private String descripcionServicio;
	private int idOrigen;
	private String descripcionOrigen;
	private int idClaseTransaccion;
	private String descripcionClaseTransaccion;
	private int idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
	private int idCanal;
	private String descripcionCanal;
	private int idInstitucionEmisora;
	private String descripcionInstEmisora;
	private int idInstitucionReceptora;
	private String descripcionIntReceptora;
	private int idATM;
	private String nombreATM;
	private String idProceso;
	private String descripcionProceso;
	private String idBIN;
	private String descripcionBIN;
	private int idRol;
	private String descripcionRolTransaccion;

}
