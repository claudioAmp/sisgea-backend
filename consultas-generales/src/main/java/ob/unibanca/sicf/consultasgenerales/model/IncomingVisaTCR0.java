package ob.unibanca.sicf.consultasgenerales.model;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTCR0 {

		private int idSecuenciaIncoming;
		private String transactionCode;
		private String transCodeQualifier;
		private String accountNumber;
		private String accountNumberExt;
		private String floorLimitIndicator;
		private String crbExceptionFileInd;
		private String pcasIndicator;
		private String acquirerRefNumber;
		private String acquirerBusinessId;
		private Date purchaseDate;
		private Integer destinationAmount;
		private Integer destCurrencyCode;
		private Integer sourceAmount;
		private Integer sourceCurrencyCode;
		private String merchantName;
		private String merchantCity;
		private String merchantCountryCode;
		private String merchantCategoryCode;
		private String merchantZipCode;
		private String merchantStateCode;
		private String requestPaymentServ;
		private String numberPaymentForms;
		private String reasonCode;
		private String usageCode;
		private String settlementFlag;
		private String authorizationIndicator;
		private String authorizationCode;
		private String posTerminalCapability;
		private String cardholderIdMethod;
		private String collectionOnlyFlag;
		private String entryMode;
		private Date CentralProcessingDate;
		private String ReimbursementAttribute;
		private Date FechaProceso;

}
