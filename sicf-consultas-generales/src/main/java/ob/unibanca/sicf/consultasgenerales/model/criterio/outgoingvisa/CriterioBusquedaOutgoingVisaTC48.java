package ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa;

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
public class CriterioBusquedaOutgoingVisaTC48 {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionFin;	
	private Integer transactionCurrencyCode;
	private String accountNumber;
	private List<String> responsesCodes;
	private List<String> merchantTypes;
	
	//filtros
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroDestinationBin;
	private String filtroSourceBin;
	private String filtroAccountNumber;
	private String filtroResponseCode;
	private String filtroStandInResponseCode;
	private String filtroTransactionCurrencyCode;
	private String filtroTransactionAmount;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroTransactionDate;
	private String filtroTransactionTime;
	private String filtroMerchantType;
	private String filtroSecuenciaOutgoing;
	
	private String ordenFechaProceso;
	private String ordenDestinationBin;
	private String ordenSourceBin;
	private String ordenAccountNumber;
	private String ordenResponseCode;
	private String ordenStandInResponseCode;
	private String ordenTransactionCurrencyCode;
	private String ordenTransactionAmount;
	private String ordenTransactionDate;
	private String ordenTransactionTime;
	private String ordenMerchantType;
	private String ordenSecuenciaOutgoing;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoTransactionAmountMin;
	private Double rangoTransactionAmountMax;
}