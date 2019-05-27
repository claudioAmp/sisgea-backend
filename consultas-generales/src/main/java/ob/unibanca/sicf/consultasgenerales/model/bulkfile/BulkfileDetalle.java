package ob.unibanca.sicf.consultasgenerales.model.bulkfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BulkfileDetalle {

	String messageTypeInd;
	String descripcionMessageTypeInd;
	Integer switchSerialNumber;
	String processorAcqIss;
	String processorId;
	Date transactionDate;
	String transactionTime;
	Integer panLength;
	String accountNumber;
	String processingCode;
	String descripcionProcessingCode;
	String traceNumber;
	String merchantType;
	String descripcionMerchantType;
	String posEntry;
	String modEntradaPos;
	String capacidadEntradaPin;
	String referenceNumber;
	String acquirerInstId;
	String terminalId;
	Integer responseCode;
	String descripcionResponseCode;
	String brand;
	String adviceReasonCode;
	String intracurrencyAgreeCode;
	String authorizationId;
	Integer currencyCodeTran;
	Integer impliedDecimalTran;
	Integer amountTransactionLoc;
	String amountTransactionLocInd;
	Integer cashbackAmountLoc;
	String cashbackAmountLocInd;
	Integer accessFeeLoc;
	String accessFeeLocInd;
	Integer currencyCodeSett;
	Integer impliedDecimalSett;
	Integer conversionRateSett;
	Integer amountSettlement;
	String amountSettlementInd;
	Integer interchangeFee;
	String interchangeFeeInd;
	String serviceLevelInd;
	String responseCode2;
	Integer positiveIdInd;
	String atmSurchargeFree;
	String crossBordeInd;
	String crossBorderCurrInd;
	Integer visaIsaFeeInd;
	String descripcionVisaIsaFeeInd;
	String reqAmountTransLoc;
	Date fechaProceso;
}
