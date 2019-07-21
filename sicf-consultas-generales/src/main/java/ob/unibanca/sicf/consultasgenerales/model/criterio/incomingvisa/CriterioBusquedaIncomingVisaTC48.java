package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingVisaTC48 {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionFin;	
	private String accountNumber;
	private List<String> standInReasonsCodes;
	private List<String> responsesCodes;
	private List<String> merchantTypes;
	
	//filtros
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroSecuenciaIncoming;
	private String filtroDestinationBin;
	private String filtroSourceBin;
	private String filtroAccountNumber;
	private String filtroResponseCode;
	private String filtroTransactionCurrencyCode;
	private String filtroTransactionAmount;
	private String filtroTransmissionDateTime;
	private String filtroTransactionTime;
	private String filtroMerchantType;
	
	private String ordenFechaProceso;
	private String ordenSecuenciaIncoming;
	private String ordenDestinationBin;
	private String ordenSourceBin;
	private String ordenAccountNumber;
	private String ordenResponseCode;
	private String ordenTransactionCurrencyCode;
	private String ordenTransactionAmount;
	private String ordenTransmissionDateTime;
	private String ordenTransactionTime;
	private String ordenMerchantType;
}
