package ob.unibanca.sicf.consultasgenerales.model.bulkfile;

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
public class Bulkfile {
	
	String idBulkFileMc;
	String messageTypeInd;
	String descripcionMessageTypeInd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date transactionDate;
	String transactionTime;
	@TruncarPAN
	String accountNumber;
	String processingCode;
	String idProceso;
	String descripcionProceso;
	String traceNumber;
	String terminalId;
	@TruncarPAN
	Integer responseCode;
	String descripcionResponseCode;
	String authorizationId;
	Integer idEmisor;
	String descripcionEmisor;
	Integer idReceptor;
	String descripcionReceptor;
	Integer currencyCodeTran;
	String descripcionCurrencyCodeTran;
	Double amountTransactionLoc;
	Double accessFeeLoc;
	String accessFeeLocInd;
	Integer currencyCodeSett;
	String descripcionCurrencyCodeSett;
	String posEntry;
	String modEntradaPos;//
	String descripcionModEntradaPos;
	String capacidadEntradaPin;//
	String descripcionCapacidadEntradaPin;//
	Double amountSettlement;
	String amountSettlementInd;
	Double interchangeFee;
	String interchangeFeeInd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	
	String idMembresia;
	String descripcionMembresia;
	String idServicio;
	String descripcionServicio;
	Integer idOrigen;
	String descripcionOrigen;
	Integer idClaseTransaccion;
	String descripcionClaseTransaccion;
	Integer idCodigoTransaccion;
	String descripcionCodigoTransaccion;
	Integer idInstitucionEmisora;
	String descripcionInstitucionEmisora;
	Integer idInstitucionReceptora;
	String descripcionInstitucionReceptora;
}
