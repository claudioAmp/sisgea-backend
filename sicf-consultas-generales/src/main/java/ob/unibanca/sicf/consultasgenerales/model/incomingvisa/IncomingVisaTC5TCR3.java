package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IncomingVisaTC5TCR3 {
	private Long idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private String businessFormatCode;
	private String dataContent;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
}
