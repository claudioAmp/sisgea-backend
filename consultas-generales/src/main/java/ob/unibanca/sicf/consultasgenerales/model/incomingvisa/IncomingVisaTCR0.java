package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IncomingVisaTCR0 {

		private Integer idSecuenciaIncoming;
		private String transactionCode;
		private String descTransactionCode;
		private String transCodeQualifier;
		private String descTransCodeQualifier;
		private String idBin;
		private String descIdBin;
		private String binReceptor;
		private String accountNumber;
		private String floorLimitIndicator;
		private String descFloorLimitIndicator;
		private String crbExceptionFileInd;
		private String pcasIndicator;
		private String acquirerRefNumber;
		private String acquirerBusinessId;
		private Date purchaseDate;
		private Integer destinationAmount;
		private Integer destCurrencyCode;
		private String descDestCurrencyCode;
		private Integer sourceAmount;
		private Integer sourceCurrencyCode;
		private String descSourceCurrencyCode;
		private String merchantName;
		private String merchantCity;
		private String merchantCountryCode;
		private String descMerchantCountryCode;
		private String merchantCategoryCode;
		private String descMerchantCategoryCode;
		private String merchantZipCode;
		private String merchantStateCode;
		private String requestPaymentServ;
		private String numberPaymentForms;
		private String reasonCode;
		private String usageCode;
		private String descUsageCode;
		private String settlementFlag;
		private String authorizationIndicator;
		private String authorizationCode;
		private String posTerminalCapability;
		private String descPosTerminalCapability;
		private String cardholderIdMethod;
		private String descCardholderIdMethod;
		private String collectionOnlyFlag;
		private String entryMode;
		private Date centralProcessingDate;
		private String reimbursementAttribute;
		private Date fechaProceso;
		private Integer institucionEmisora;
		private Integer institucionReceptora;
		private String descInstitucionEmisora;
		private String descInstitucionReceptora;
		private Integer idOrigen;
		private String descIdOrigen;
		private Integer idProducto;
		private String descidProducto;
		private Integer totalFilas;//agregado

}
