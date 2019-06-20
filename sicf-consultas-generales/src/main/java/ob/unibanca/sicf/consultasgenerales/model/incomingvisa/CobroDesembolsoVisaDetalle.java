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
public class CobroDesembolsoVisaDetalle {
	private Integer secuenciaIncoming;
	private String transactionCode;
	private String transCodeQualifer;
	private String destinationBin;
	private String sourceBin;
	private String reasonCode;
	private String countryCode;
	private Date eventDate;
	private String accountNumber;
	private String accountNumberExt;
	private double destinationAmount;
	private String destCurrencyCode;
	private double sourceAmount;
	private String sourceCurrencyCode;
	private String messageType;
	private String settlementFlag;
	private String transactionIdentifier;
	private Date centralProcessing;
	private String reimbursementAttribute;
	private Date fechaProceso;
}
