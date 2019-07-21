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
public class IncomingVisaTC5 {
	private Long idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	private String accountNumber;
	private String acquirerRefNumber;
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
	private Date fechaProceso;
	private Integer institucionEmisora;
	private Integer institucionReceptora;
	private String descInstitucionEmisora;
	private String descInstitucionReceptora;
	private Integer idProducto;
	private Integer idCanal;
	private String descCanal;
	private Date fechaIncoming;

}
