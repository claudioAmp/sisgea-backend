package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTC5TCR5 {
	
	private String idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private String transactionIdentifier;
	private Double authorizedAmount;
	private String authorizCurrencyCode;
	private String descAuthorizCurrencyCode;
	private String authorizResponseCode;
	private String validationCode;
	private String excludedTransIdReason;
	private String crsProcessingCode;
	private String chargebackRightsInd;
	private String descChargebackRightsInd;
	private Integer multipleClearingSeqNumb;
	private Integer multipleClearingSeqCount;
	private String marketAuthorizDataInd;
	private Integer totalAuthorizedAmount;
	private String informationIndicator;
	private String merchantTelephoneNum;
	private String merchantVolumeInd;
	private String electronicCommerceGoods;
	private String merchantVerificationValue;
	private Double interchangeFeeAmount;
	private String interchangeFeeSign;
	private Double sourceCurrencyRate;
	private Double baseCurrencyRate;
	private Double optionalIssuerIsaAmount;
	private String productId;
	private String programId;
	private String dccIndicator;
	private String accountTypeId;
	private String spendQualifiedInd;
	private String panToken;
	private String cvv2ResultCode;
	private String descCvv2ResultCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
}
