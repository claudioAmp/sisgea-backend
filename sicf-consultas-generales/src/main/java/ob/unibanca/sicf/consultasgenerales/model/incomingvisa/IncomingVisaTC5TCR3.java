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

public class IncomingVisaTC5TCR3 {
	
	private String idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private String businessFormatCode;
	private String dataContent;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
}
