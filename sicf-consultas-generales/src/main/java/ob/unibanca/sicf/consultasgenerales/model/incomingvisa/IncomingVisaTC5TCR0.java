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
public class IncomingVisaTC5TCR0 {
	
	private String idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	@TruncarPAN
	private String accountNumber;
	private String accountNumberExt;
	private String floorLimitIndicator;
	private String descFloorLimitIndicator;
	private String crbExceptionFileInd;
	private String descCrbExceptionFileInd;
	private String pcasIndicator;
	private String acquirerRefNumber;
	private String acquirerBusinessId;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date purchaseDate;
	private Double destinationAmount;
	private Integer destCurrencyCode;
	private String descDestCurrencyCode;
	private Double sourceAmount;
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
	private String descReasonCode;
	private String usageCode;
	private String descUsageCode;
	private String settlementFlag;
	private String authorizationIndicator;
	private String descAuthorizationIndicator;
	private String authorizationCode;
	private String posTerminalCapability;
	private String descPosTerminalCapability;
	private String cardholderIdMethod;
	private String descCardholderIdMethod;
	private String collectionOnlyFlag;
	private String posEntryMode;
	private String descPosEntryMode;
	private Date centralProcessingDate;
	private String reimbursementAttribute;
	private String descReimbursementAttribute;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String idBin;
	private String descBin;
	private String binReceptor;
	private String descBinReceptor;
	private Integer institucionEmisora;
	private Integer institucionReceptora;
	private String descInstitucionEmisora;
	private String descInstitucionReceptora;
	private Integer idOrigen;
	private String descIdOrigen;
	private Integer idProducto;
	private Integer idCanal;
	private String descCanal;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaIncoming;
	private String descProducto;
	
	private String posConditionCode;
	private Double surchargeAmountSwdmplog;
	private String traceNumber;
	private String transmissionTime;
	private String accountIdentification;
	private String processingCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date captureDate;
	private String idProceso;
	private String descripcionProceso;
	private String idOrigenArchivoConc;
	private String descripcionOrigenArchivoConc;
	private String secuenciaOrigenConc;
	private Integer indConciliacion;
	private String descripcionConciliacion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaConciliacion;
}
