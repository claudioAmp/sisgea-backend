package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IncomingVisatTC5TCR3 {
	private Integer idSecuenciaIncoming;
	private String businessFormatCode;
	private String dataContent;
	private Date fechaProceso;
}
