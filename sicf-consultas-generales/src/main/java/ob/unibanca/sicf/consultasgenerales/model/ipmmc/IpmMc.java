package ob.unibanca.sicf.consultasgenerales.model.ipmmc;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class IpmMc {
	
	private String tramsKey;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String pan;
	private String typeRecord;
	private String descTypeRecord;
	private Double amountTxn;
	private Double amountCardholder;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateLocalTxn;
	private String timeLocalTxn;
	private String cardDataInputCapability;
	private String descCardDataInputCapability;
	private String cardDataInputMode;
	private String descCardDataInputMode;
	private String cardhAuthenticationMethod;
	private String descCardhAuthenticationMethod;
	private String cardAcceptorBusinessCode;
	private String descCardAcceptorBusinessCode;
	private String acquirerReferenceData;
	private String approvalCode;
	private String cardAcceptorName;
	private String cardAcceptorCountrycode;
	private String descCardAcceptorCountrycode;
	private Integer currencyCodeTransaction;
	private String descCurrencyCodeTransaction;
	private Integer currencyCodeCardholder;
	private String descCurrencyCodeCardholder;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date settlDate;
	private Integer idTransaccion;
	private String  descIdTransaccion;
	private Integer idProducto;
	private String descProducto;
	private Integer idCanal;
	private String descCanal;
	private Integer idInstitucionEmisora;
	private String descInstitucionEmisora;
	private Integer idInstitucionReceptora;
	private String descInstitucionReceptora;
	private String idProceso;
	private String descIdProceso;
	private String idBin;
	private String descBin;
}
