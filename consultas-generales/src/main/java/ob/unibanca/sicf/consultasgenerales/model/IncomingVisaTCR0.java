package ob.unibanca.sicf.consultasgenerales.model;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.ItemPagina;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IncomingVisaTCR0 extends ItemPagina{

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
		private Date centralProcessingDate;
		private String reimbursementAttribute;
		private Date fechaProceso;
		
		private Integer totalFilas;//agregado

}
