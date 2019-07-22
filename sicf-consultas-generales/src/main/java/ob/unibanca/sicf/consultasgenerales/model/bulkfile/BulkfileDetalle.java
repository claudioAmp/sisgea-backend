package ob.unibanca.sicf.consultasgenerales.model.bulkfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BulkfileDetalle {
	Long idBulkFileMc;
	String messageTypeInd;
	String descripcionMessageTypeInd;
	Integer switchSerialNumber;
	String processorAcqIss;
	String processorId;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date transactionDate;
	String transactionTime;
	Integer panLength;
	String accountNumber;
	String processingCode;
	String traceNumber;
	String merchantType;
	String descripcionMerchantType;
	String posEntry;
	String modEntradaPos;//
	String capacidadEntradaPin;//
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
	double amountTransactionLoc;
	String amountTransactionLocInd;
	Integer cashbackAmountLoc;
	String cashbackAmountLocInd;
	double accessFeeLoc;
	String accessFeeLocInd;
	Integer currencyCodeSett;
	String descripcionCurrencyCodeSett;
	Integer impliedDecimalSett;
	double conversionRateSett;
	double amountSettlement;
	String amountSettlementInd;
	double interchangeFee;
	String interchangeFeeInd;
	String serviceLevelInd;
	String responseCode2;
	Integer positiveIdInd;
	String atmSurchargeFree;
	String crossBordeInd;
	String crossBorderCurrInd;
	Integer visaIsaFeeInd;//
	String descripcionVisaIsaFeeInd;
	String reqAmountTransLoc;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
}
