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
public class BulkfileDetalle {
	
	String idBulkFileMc;
	String messageTypeInd;
	String descripcionMessageTypeInd;
	Integer switchSerialNumber;
	String processorAcqIss;
	String descripcionProcessorAcqIss;
	String processorId;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date transactionDate;
	String transactionTime;
	Integer panLength;
	@TruncarPAN
	String accountNumber;
	String processingCode;
	Integer idProceso;
	String descripcionProceso;
	String traceNumber;
	String merchantType;
	String descripcionMerchantType;
	String posEntry;
	String modEntradaPos;//
	String descripcionModEntradaPos;
	String capacidadEntradaPin;//
	String descripcionCapacidadEntradaPin;//
	String referenceNumber;
	String acquirerInstId;
	String terminalId;
	Integer responseCode;
	String descripcionResponseCode;
	String brand;
	String adviceReasonCode;
	String intracurrencyAgreeCode;
	String authorizationId;
	Integer idEmisor;
	String descripcionEmisor;
	Integer idReceptor;
	String descripcionReceptor;
	Integer currencyCodeTran;
	String descripcionCurrencyCodeTran;
	Integer impliedDecimalTran;
	Double amountTransactionLoc;
	String amountTransactionLocInd;
	String descripcionAmountTransactionLocInd; //
	Integer cashbackAmountLoc;
	String cashbackAmountLocInd;
	String descripcionCashbackAmountLocInd; //
	Double accessFeeLoc;
	String accessFeeLocInd;
	String descripcionAccessFeeLocInd; //
	Integer currencyCodeSett;
	String descripcionCurrencyCodeSett;
	Integer impliedDecimalSett;
	Double conversionRateSett;
	Double amountSettlement;
	String amountSettlementInd;
	String descripcionAmountSettlementInd;//
	Double interchangeFee;
	String interchangeFeeInd;
	String descripcionInterchangeFeeInd; //
	String serviceLevelInd;
	String descripcionServiceLevelInd; //
	String responseCode2;
	Integer positiveIdInd;
	String descripcionPositiveIdInd; //
	String atmSurchargeFree;
	String descripcionAtmSurchargeFree; //
	String crossBordeInd;
	String descripcionCrossBordeInd; //
	String crossBorderCurrInd;
	String descripcionCrossBorderCurrInd; //
	Integer visaIsaFeeInd;//
	String descripcionVisaIsaFeeInd;
	String reqAmountTransLoc;
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
	
	String messageType;
	String acquiringInstitution;
	String descripcionBinInstAdq;
	String merchantName;
	String authorizationCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date captureDate;
	String idOrigenArchivoConc;
	String descripcionOrigenArchivoConc;
	Long secuenciaOrigenConc;
	Integer indConciliacion;
	String descripcionConciliacion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaConciliacion;
}
