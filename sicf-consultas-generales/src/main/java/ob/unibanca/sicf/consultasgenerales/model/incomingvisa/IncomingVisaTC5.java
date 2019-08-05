package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

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
public class IncomingVisaTC5 {
	
	private Long idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	@TruncarPAN
	private String accountNumber;
	private String acquirerRefNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private Integer institucionEmisora;
	private Integer institucionReceptora;
	private String descInstitucionEmisora;
	private String descInstitucionReceptora;
	private Integer idProducto;
	private String descProducto;
	private Integer idCanal;
	private String descCanal;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaIncoming;
	private String idBin;
	private String descBin;
	private String cardholderIdMethod;
	private String descCardholderIdMethod;
	private String posTerminalCapability;
	private String descPosTerminalCapability;
	private String posEntryMode;
	private String descPosEntryMode;
}
