package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTCR5 {
	private Integer idSecuenciaIncoming;
	private String transactionIdentifier;
	private Integer authorizedAmount;
	private String authorizCurrencyCode;
	private String authorizResponseCode;
	private String validationCode;
	private String excludedTransIdReason;
	private String crsProcessingCode;
	private String chargebackRightsInd;
	private Integer multipleClearingSeqNumb;
	private Integer multipleClearingSeqCount;
	private String marketAuthorizDataInd;
	private Integer totalAuthorizedAmount;
	private String informationIndicator;
	private String merchantTelephoneNum;
	private String merchantVolumeInd;
	private String electronicCommerceGoods;
	private String merchantVerificationValue;
	private Integer interchangeFeeAmount;
	private String interchangeFeeSign;
	private Integer sourceCurrencyRate;
	private Integer baseCurrencyRate;
	private Integer optionalIssuerIsaAmount;
	private String productId;
	private String programId;
	private String dccIndicator;
	private String accountTypeId;
	private String spendQualifiedInd;
	private String panToken;
	private String cvv2ResultCode;
	private Date fechaProceso;
}
