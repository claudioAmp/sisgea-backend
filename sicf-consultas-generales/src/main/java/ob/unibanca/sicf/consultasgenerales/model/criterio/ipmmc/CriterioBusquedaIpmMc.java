package ob.unibanca.sicf.consultasgenerales.model.criterio.ipmmc;

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
public class CriterioBusquedaIpmMc {
	
	private String tramsKey;//x
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;//x
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;//x
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionInicio; // dateLocalTransaction
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionFin; // dateLocalTransaction
	private String pan;//x
	private List<String> typesRecord; //VALOR 1ST y 2ND Debe ir a Una Mutitabla 
	private List<String> processingCodes;
	private List<String> cardAuthsMethod; //modo entreda POS
	private List<String> cardAcceptorsCode; //MCC
	private List<String> acqInstitutions; //Tiene longitud 1 a 11
	private List<String> forInstitutions; //varia de 6 a 11 en longitud 
	private List<Integer> currencysCode; //Longitud 3
	
	//filtros Grilla
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroDateLocalTxn;
	private String filtroPan;
	private String filtroTypeRecord;
	private String filtroProcessingCode;
	private String filtroTimeLocalTxn;
	private String filtroCardhAuthenticationMethod;
	private String filtroCardAcceptorBusinessCode;
	private String filtroAcquiringInstitutionIdcode;
	private String filtroForwardingInstitutionIdcode;
	private String filtroCardAcceptorName;
	private String filtroCardAcceptorCity;
	private String filtroCardAcceptorCountrycode;
	private String filtroCurrencyCodeTransaction;
	private String filtroCurrencyCodeReconciliation;
	private String filtroTramsKey;
	
	//orden Grilla
	private String ordenFechaProceso;
	private String ordenDateLocalTxn;
	private String ordenPan;
	private String ordenTypeRecord;
	private String ordenProcessingCode;
	private String ordenAmountTxn;
	private String ordenAmountReconcilia;
	private String ordenAmountCardholder;
	private String ordenTimeLocalTxn;
	private String ordenCardhAuthenticationMethod;
	private String ordenCardAcceptorBusinessCode;
	private String ordenAcquiringInstitutionIdcode;
	private String ordenForwardingInstitutionIdcode;
	private String ordenCardAcceptorName;
	private String ordenCardAcceptorCity;
	private String ordenCardAcceptorCountrycode;
	private String ordenCurrencyCodeTransaction;
	private String ordenCurrencyCodeReconciliation;
	private String ordenTramsKey;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoAmountTxnMin;
	private Double rangoAmountTxnMax;
	private Double rangoAmountReconciliaMin;
	private Double rangoAmountReconciliaMax;
	private Double rangoAmountCardholderMin;
	private Double rangoAmountCardholderMax;
	
}
